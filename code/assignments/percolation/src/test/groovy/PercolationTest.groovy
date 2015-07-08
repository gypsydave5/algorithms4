import spock.lang.Specification

class PercolationTest extends Specification{

    def "starts with sites unopened"() {
        given:
        def percolator = new Percolation(2)
        expect:
        percolator.isOpen(1, 1) == false
        percolator.isFull(1, 1) == false
    }

    def "Percolation knows when it has opened a site"() {
        given:
        def percolator = new Percolation(2)
        when:
        percolator.open(1, 1)
        then:
        percolator.isOpen(1, 1) == true
        percolator.isFull(1, 1) == true
    }

    def "knows when a site is not full"() {
        given:
        def percolator = new Percolation(2)
        when:
        percolator.open(2, 2)
        then:
        percolator.isFull(2, 2) == false
    }

    def "knows when a site is full)"() {
        given:
        def percolator = new Percolation(4)
        when:
        percolator.open(1, 1)
        percolator.open(1, 2)
        percolator.open(1, 3)
        percolator.open(4, 4)
        then:
        percolator.isFull(1, 3) == true
        percolator.isFull(4, 4) == false

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
        new Percolation(-5)
        then:
        thrown(IllegalArgumentException)
    }

    def "doesn't backwash"() {
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
        percolator.open(1, 5)
        then:
        percolator.percolates() == true
        percolator.isFull(1, 5) == false
    }

    def "works like for a 10 by 10"() {
        given:
        def percolator = new Percolation(10)
        when:
        (1..10).each { i -> percolator.open(1, i) }
        then:
        percolator.percolates() == true
    }
}
