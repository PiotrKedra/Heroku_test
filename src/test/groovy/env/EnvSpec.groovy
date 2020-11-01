package env

import spock.lang.Specification

class EnvSpec extends Specification {

    def "should run spock test"() {
        expect:
        1 + 1 == 2
    }
}
