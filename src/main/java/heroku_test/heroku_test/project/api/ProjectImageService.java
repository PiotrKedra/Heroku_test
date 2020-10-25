package heroku_test.heroku_test.project.api;

import heroku_test.heroku_test.project.api.dao.ProjectImageEntity;
import heroku_test.heroku_test.project.api.dao.ProjectImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Component
class ProjectImageService {

    private final ProjectImageRepository projectImageRepository;

    @Autowired
    public ProjectImageService(ProjectImageRepository projectImageRepository) {
        this.projectImageRepository = projectImageRepository;
    }

    Long creatProjectImage(MultipartFile file) {
        try {
            System.out.println("Original Image Byte Size - " + file.getBytes().length);
            ProjectImageEntity img = new ProjectImageEntity(file.getOriginalFilename(), file.getContentType(),
                    compressBytes(file.getBytes()));
            ProjectImageEntity projectImage = projectImageRepository.save(img);
            return projectImage.getId();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    Optional<ProjectImageEntity> getImage(Long id) {
        final Optional<ProjectImageEntity> retrievedImage = projectImageRepository.findById(id);
        return retrievedImage.map(img -> new ProjectImageEntity(img.getName(), img.getType(), decompressBytes(img.getImageBytes())));
    }

    private static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    private static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
