import spock.lang.Specification

class PercolationStatsTest extends Specification {

    def "works"() {
        given:
        def pstat = new PercolationStats(10, 10)
        when:
        def res = pstat.mean()
        then:
        res < 1
        res > 0
    }

    def "throws an error if N is less than 1"() {
        when:
        def pstat = new PercolationStats(0, 10)
        then:
        thrown(IllegalArgumentException)
    }

    def "throws an error if T is less than 1"() {
        when:
        def pstat = new PercolationStats(10, -10)
        then:
        thrown(IllegalArgumentException)
    }
}
