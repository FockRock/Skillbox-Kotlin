fun main() {
    val o = AlphaCard()
    o.getInfo()
    o.deposit(50000)
    o.deposit(45600)
    o.deposit(4600)
    o.pay(7490)
    o.pay(34557)

    val t = TinkoffCard()
    t.getInfo()
    t.deposit(70000)
    t.pay(600)
    t.deposit(800)
    t.pay(7490)

    val s = SberCard()
    s.getInfo()
    s.deposit(1000)
    s.pay(900)
    s.pay(257)
}