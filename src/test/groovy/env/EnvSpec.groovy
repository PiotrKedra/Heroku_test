package env

import spock.lang.Specification

class EnvSpec extends Specification {

    def "should run spock test"() {
        expect:
        1 + 1 == 2
    }

    def "should fail test"() {
        expect:
        1 + 1 == 1
    }
}
