import spock.lang.Specification

class DequeueTest extends Specification {

    def "Dequeue initializes empty"() {
        given:
        def dequeue = new Dequeue()
        expect:
        dequeue.isEmpty() == true
    }

    def "can be given a generic type"() {
        given:
        def dequeue = new Dequeue<Integer>()
    }

    def "can have items added to the front"() {
        given:
        def dequeue = new Dequeue<Integer>()
        expect:
        dequeue.addFirst(1)
    }

    def "can have items popped from the front"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        dequeue.addFirst(77)
        then:
        dequeue.removeFirst() == 77
    }

    def "knows when it's not empty"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        dequeue.addFirst(77)
        then:
        dequeue.isEmpty() == false
    }

    def "can have items added to the rear"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        dequeue.addLast(88)
        then:
        dequeue.removeLast() == 88
    }

    def "knows that the front is the back when there's just one item"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        dequeue.addLast(88)
        then:
        dequeue.removeFirst() == 88
    }

    def "knows that it's empty when it runs out of items"() {
        given:
        def dequeue = new Dequeue<String>()
        when:
        dequeue.addFirst("bob")
        dequeue.addFirst("bill")
        def bill = dequeue.removeFirst()
        def bob = dequeue.removeLast()
        then:
        bob == 'bob'
        bill == 'bill'
        dequeue.isEmpty() == true
    }

    def "can keep being added to at the front"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        (1..100).each { i -> dequeue.addFirst(i) }
        then:
        dequeue.removeFirst() == 100
        dequeue.removeLast() == 1
    }

    def "... and at the back"() {
        given:
        def dequeue = new Dequeue<Integer>()
        when:
        (1..100).each { i -> dequeue.addLast(i) }
        then:
        dequeue.removeFirst() == 1
        dequeue.removeLast() == 100
    }

    def "Can't really test that it's shrinking right - more for regression"() {
        given:
        def dequeue = new Dequeue<Boolean>()
        when:
        100.times { dequeue.addFirst(true) }
        99.times { dequeue.removeFirst() }
        then:
        dequeue.removeLast() == true
    }

    def "And do the same backwards..."() {
        given:
        def dequeue = new Dequeue<Boolean>()
        when:
        100.times { dequeue.addLast(true) }
        99.times { dequeue.removeLast() }
        then:
        dequeue.removeFirst() == true
    }

    def "And now them all"() {
        given:
        def dequeue = new Dequeue<String>()
        when:
        5.times { dequeue.addLast("b") }
        5.times { dequeue.addFirst("a") }
        5.times { dequeue.removeFirst() }
        5.times { dequeue.removeLast() }
        def whenEmpty = dequeue.removeFirst()
        def stillEmpty = dequeue.removeLast()
        then:
        whenEmpty == null
        stillEmpty == null
    }
}
