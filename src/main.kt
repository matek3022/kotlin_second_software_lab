val t: ArrayList<Int> = ArrayList<Int>()
val n: ArrayList<Int> = ArrayList<Int>()

fun main(args : Array<String>) {
    with(t) {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
        add(6)
        add(7)
    }
    with(n) {
        add(5)
        add(5)
        add(2)
        add(1)
        add(1)
        add(0)
        add(0)
    }
    println(find(0f,1f))
}

fun calculate(k : Double) : Double {
    var sum1 = 0.0
    var sum2 = 0.0
    var sum3 = 0.0
    var sum4 = 0.0
    for (item in t) {
        sum1 += n[item - 1] * Math.exp(-k * item)
        sum2 += n[item - 1] * item * Math.exp(-k * item)
        sum3 += item * Math.exp(-2 * k * item)
        sum4 += Math.exp(-2 * k * item)
    }

    println("Summ left = " + sum1)
    println("Summ right = " + (sum2 / sum3) * sum4)
    return (sum1 - (sum2/sum3)*sum4)
}

fun find(k0: Float, k1: Float) : Float {
    val eps = 0.00001f
    var left = k0
    var right = k1
    var k : Float
    var f : Float
    var iter : Int = 0
    println("k0 = " + k0 + "; k1 = " + k1)
    do{
        k = (left + right) / 2;
        println("----------------------------------------")
        println("k = " + k)
        f = calculate(k.toDouble()).toFloat()
        if (f < 0) right = k
        else left = k
        iter++
    } while (Math.abs(f) > eps)
    println("" + iter + " - iterations")
    return k
}