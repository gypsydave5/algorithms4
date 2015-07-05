import spock.lang.Specification

class PercolationTest extends Specification{

    def "starts with sites unopened"() {
        given:
        def percolator = new Percolation(2)
        expect:
        percolator.isOpen(1, 1) == false
    }

    def "Percolation knows when it has opened a site"() {
        given:
        def percolator = new Percolation(2)
        when:
        percolator.open(1, 1)
        then:
        percolator.isOpen(1, 1) == true
    }

    def "Percolation knows when it percolates"() {
        given:
        def percolator = new Percolation(3)
        when:
        percolator.open(1, 1)
        percolator.open(1, 3)
        percolator.open(1, 2)
        then:
        percolator.percolates() == true
    }

    def "Percolation REALLY knows when it percolates"() {
        given:
        def percolator = new Percolation(5)
        when:
        percolator.open(1, 1)
        percolator.open(1, 2)
        percolator.open(1, 3)
        percolator.open(2, 3)
        percolator.open(3, 3)
        percolator.open(3, 4)
        percolator.open(3, 5)
        then:
        percolator.percolates() == true
    }

    def "Percolation REALLY knows when it percolates in any order"() {
        given:
        def percolator = new Percolation(5)
        when:
        percolator.open(1, 1)
        percolator.open(3, 3)
        percolator.open(1, 3)
        percolator.open(2, 3)
        percolator.open(3, 5)
        percolator.open(3, 4)
        percolator.open(1, 2)
        then:
        percolator.percolates() == true
        percolator.isOpen(3, 4)
    }

    def "throws an exception when given a negative argument"() {
        when:
        def percolator = new Percolation(-5)
        then:
        thrown(IllegalArgumentException)
    }
}
