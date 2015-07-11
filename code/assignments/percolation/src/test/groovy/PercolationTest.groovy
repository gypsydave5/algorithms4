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
        percolator.open(2, 1)
        percolator.open(3, 1)
        percolator.open(4, 4)
        then:
        percolator.isFull(3, 1) == true
        percolator.isFull(4, 4) == false

    }

    def "Percolation knows when it percolates"() {
        given:
        def percolator = new Percolation(3)
        when:
        percolator.open(1, 1)
        percolator.open(3, 1)
        percolator.open(2, 1)
        then:
        percolator.percolates() == true
    }

    def "Percolation REALLY knows when it percolates"() {
        given:
        def percolator = new Percolation(5)
        when:
        percolator.open(1, 1)
        percolator.open(2, 1)
        percolator.open(3, 1)
        percolator.open(3, 2)
        percolator.open(3, 3)
        percolator.open(4, 3)
        percolator.open(5, 3)
        then:
        percolator.percolates() == true
    }

    def "Percolation REALLY knows when it percolates in any order"() {
        given:
        def percolator = new Percolation(5)
        when:
        percolator.open(5, 3)
        percolator.open(2, 1)
        percolator.open(3, 3)
        percolator.open(3, 1)
        percolator.open(4, 3)
        percolator.open(3, 2)
        percolator.open(1, 1)
        then:
        percolator.percolates() == true
        percolator.isOpen(4, 3)
    }

    def "percolation goes up and down"() {
        given:
        def percolator = new Percolation(5)
        when:
        percolator.open(1, 5)
        percolator.open(2, 5)
        percolator.open(2, 4)
        percolator.open(2, 3)
        percolator.open(2, 2)
        percolator.open(3, 2)
        percolator.open(4, 2)
        percolator.open(5, 2)
        then:
        percolator.percolates() == true
        percolator.isOpen(1, 5)
        percolator.isOpen(2, 5)
        percolator.isOpen(2, 4)
        percolator.isOpen(2, 3)
        percolator.isOpen(2, 2)
        percolator.isOpen(3, 2)
        percolator.isOpen(4, 2)
        percolator.isOpen(5, 2)
        percolator.isFull(1, 5)
        percolator.isFull(2, 5)
        percolator.isFull(2, 4)
        percolator.isFull(2, 3)
        percolator.isFull(2, 2)
        percolator.isFull(3, 2)
        percolator.isFull(4, 2)
        percolator.isFull(5, 2)
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
        percolator.open(2, 1)
        percolator.open(3, 1)
        percolator.open(3, 2)
        percolator.open(3, 3)
        percolator.open(4, 3)
        percolator.open(5, 3)
        percolator.open(5, 1)
        then:
        percolator.percolates() == true
        percolator.isFull(1, 5) == false
    }

    def "works like for a 10 by 10"() {
        given:
        def percolator = new Percolation(10)
        when:
        (1..10).each { i -> percolator.open(i, 1) }
        then:
        percolator.percolates() == true
    }

    def "corner case - N = 1"() {
        given:
        def percolator = new Percolation(1)
        def openperc = new Percolation(1)
        when:
        openperc.open(1, 1)
        then:
        percolator.percolates() == false
        openperc.percolates() == true
    }

    def "corner case - N = 2"() {
        given:
        def percolator = new Percolation(2)
        def openpercolator = new Percolation(2)
        when:
        percolator.open(1, 1)
        percolator.open(2, 2)
        openpercolator.open(1, 1)
        openpercolator.open(2, 2)
        openpercolator.open(1, 2)
        then:
        percolator.percolates() == false
        openpercolator.percolates() == true
    }
}
