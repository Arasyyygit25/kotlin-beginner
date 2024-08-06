package projek

import java.util.Scanner

object cucii {
    @JvmStatic
    fun main(args: Array<String>){
        val app = Laundry()
        app.menu ()
    }
}

class Laundry {

    var tgllaundry = 0
    var berat = 0
    var nama = ""
    var alamat = ""
    var laundry = ""
    var input = Scanner(System.`in`)

    fun menu() {
        var quit: String
        var harga = 0

        do {
            var ulangi = 0
            println("========================")
            println(" === APP LAUNDRY ===")
            println("========================")
            println("1. Laundry Kiloan")
            println("2. DRY Cleaning")
            println("3. Laundry Self Service")
            println("=============================")
            print("Pilih Laundry = ")
            val jenis  = input.nextInt()

            if (jenis == 1) {
                laundry = "Laundry Kiloan"
                println("=============================")
                println("NOTE = Harga Laundry perKilo adalah Rp 5.000.-")
                harga = 5_000
            } else if (jenis == 2) {
                laundry = "DRY Cleaning"
                println("=============================")
                println("NOTE = Harga Laundry adalah Rp 20.000.-")
                harga = 20_000
            } else if (jenis == 3) {
                laundry = "Laundry Self Service"
                println("=============================")
                println("NOTE = HARGA Laundry Rp 15.000.-")
                harga = 15_000
            } else {
                println("PILIHAN CUCIAN TIDAK TERSEDIA!")
                ulangi = 1
            }
            if (ulangi != 1) {

                println("===================")
                println(" == INPUT DATA == ")
                println("===================")

                print("Nama : ")
                nama = input.next()

                print("Berat : ")
                berat = input.nextInt()

                print("Alamat : ")
                alamat = input.next()

                print("Tanggal Laundry : ")
                tgllaundry = input.nextInt()

                Struk(berat, harga)

            }
            println("================")
            print("keluar? y/n = ")
            quit = input.next()
        } while (quit == "n")
    }


    fun Struk(berat: Int, harga: Int) {

        println("====================")
        println("== Hasil Struk ==")
        println("=====================")

        println("Nama = $nama ")
        println("Alamat = $alamat ")
        println("Jenis Cuci = $laundry ")
        println("Berat = $berat Kg" )
        println("Tanggal Laundry = $tgllaundry")
        val harga = berat * harga
        println("Total Bayar laundry Adalah = $harga")
    }
}