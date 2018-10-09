package demo

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class StackImplSpec extends Specification {

    def "Testing push() for success"() {
        setup:
        StackImpl stack = new StackImpl()

        when:
        stack.push("item1")

        then:
        stack.getStack().size() == 1
    }

    @Ignore
    def "testing push() for failure"() {
        setup:
        StackImpl stack = new StackImpl()

        when:
        stack.push("item1")

        then:
        stack.getStack().size() == 0
    }

    @Unroll
    def "Testing pop() for single item"() {
        given: "initializing initial stack"
        StackImpl stack = new StackImpl();

        expect: "Check initial stack"
        stack.getStack().size() == 0

        and: "insert item to stack"
        stack.push(item)

        when: "poping from stack"
        String popedItem = stack.pop()

        then: "check for expected result"
        popedItem == expectedItem

        where:
        sno | item        | expectedItem
        1   | "testItem1" | "testItem1"
        2   | "testItem2" | "testItem2"
    }

    @Unroll("Testing pop() for multiple item: #sno")
    def "Testing pop() for multiple item"() {
        given: "initializing initial stack"
        StackImpl stack = new StackImpl();

        expect: "Check initial stack"
        stack.getStack().size() == 0

        and: "insert items to stack"
        stack.push(item1)
        stack.push(item2)
        stack.push(item3)
        stack.push(item4)

        and: "create popedItem reference"
        String popedItem

        when: "poping from stack"
        popedItem = stack.pop()

        then: "check for expected result"
        popedItem == item4

        when: "poping from stack"
        popedItem = stack.pop()

        then: "check for expected result"
        popedItem == item3

        when: "poping from stack"
        popedItem = stack.pop()

        then: "check for expected result"
        popedItem == item2

        when: "poping from stack"
        popedItem = stack.pop()

        then: "check for expected result"
        popedItem == item1


//iteam4 is added
        where:
        sno | item1       | item2       | item3       | item4
        1   | "testItem1" | "testItem2" | "testItem3" | "testItem4"
        2   | "test1"     | "test2"     | "test3"     | "testItem4"
    }

    def "Tesing push for exception"() {
        given:
        StackImpl stack = new StackImpl()

        when:
        stack.push(new Integer(1))

        then:
//        thrown(Exception)
        thrown(MissingMethodException)
    }
}
