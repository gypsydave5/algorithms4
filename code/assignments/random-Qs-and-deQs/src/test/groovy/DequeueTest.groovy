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
}
