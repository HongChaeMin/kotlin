package com.example.app

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName: String, val name: String, var date: String, var seatNumber: Int)


fun main() {
    val ticket = Ticket("koreanAir", "minHong", "2022-04-01", 28);
    val ticketNormal = TicketNormal("koreanAir", "minHong", "2022-04-01", 28);

    println(ticket);
    println(ticketNormal);

    // Ticket(companyName=koreanAir, name=minHong, date=2022-04-01, seatNumber=28)
    // com.example.app.TicketNormal@2d6e8792
}