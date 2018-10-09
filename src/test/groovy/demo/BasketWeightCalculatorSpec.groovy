package demo

import spock.lang.Specification
import spock.lang.Unroll

class BasketWeightCalculatorSpec extends Specification {

    def "one-item"() { //stubbing
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add only one item"
        weightCalculator.addItem(5)

        then: "expect value of the item"
        weightCalculator.getTotalWeight() == 5

    }

    def "two-items"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add two items in the basket"
        weightCalculator.addItem(5)
        weightCalculator.addItem(13)

        then: "expect the sum of both items"
        weightCalculator.getTotalWeight() == 18
    }

    def "order-of-items-does-not-matter"() {
        given:
        def weightCalculator1 = new BasketWeightCalculator()
        def weightCalculator2 = new BasketWeightCalculator()

        when: "add same items but with different order"
        weightCalculator1.addItem(15)
        weightCalculator1.addItem(13)

        weightCalculator2.addItem(13)
        weightCalculator2.addItem(15)

        then: "expect both baskets to weigh the same"
        weightCalculator1.getTotalWeight() == 28
        weightCalculator2.getTotalWeight() == 28
    }

    @Unroll
    def "order-of-item-cannot-be-zero"() {
        given:
        def weightCalculator21 = new BasketWeightCalculator()


        when:
        weightCalculator21.addItem(iteam1)
//        weightCalculator21.greater()>0 == check1
        // == check1
        //checkItem = iteam1

        then: "expected result"
//        totalWeight = totalWeight + itemWeight
//        weightCalculator21.greater() == check2
        check1 == weightCalculator21.getTotalWeight()


        then:
        check1 == iteam1


        where:
        iteam1    | check1
        1         | 1
        2         | 2
        0         | 0
        -1        | -1
        123456789 | 123456789
        -21       | -22
        22        | -21
        -21       | 22


    }
}

//        def "order-of-item-cannot-be-negative"() {
//
//            given:
//            def weightCalculator212 = new BasketWeightCalculator()
//
//
//            when:
//            weightCalculator212.addItem(1)
////        weightCalculator21.greater()>0 == check1
//            weightCalculator212.getTotalWeight() == true
//
//            then:
//            weightCalculator212.greater() == true
//        }

//        @Unroll
//        def "total weight should be greater than zero"(){
//            given:
//            def weightCalculator = new BasketWeightCalculator()
//            def weightCalculator1 = new BasketWeightCalculator()
//
//            when: "checking whether totalWeight greater than zero"
//            items= weightCalculator.addItem(10)
//            items= weightCalculator1.addItem(0)
//
//
//            then: "expect value of the item"
//            weightCalculator.greater() == items2
//            weightCalculator1.greater() == false
//
//            where:
//            sno | items | items2
//            1 | true | true
//            2 | false | false
//        }
//    }

