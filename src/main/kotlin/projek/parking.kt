package projek

import java.util.Scanner

object parking {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = aplikasi()
        app.menu()
    }
}

class aplikasi {
    var tglMasuk = ""
    var tglKeluar = ""
    var jamMasuk = ""
    var jamKeluar = ""
    var kendaraan = ""
    var totalBayar = 0
    var input = Scanner(System.`in`)

    fun menu() {
        var quit: String
        var harga = 0

        do {
            var ulangi = 0
            println(" == Parkir == ")
            println("1. Mobil")
            println("2. Motor")
            print("Kendaraan :")
            val pilih = input.nextInt()

            if (pilih == 1) {
                kendaraan = "Mobil"
                println("Harga Parkir Mobil/JAM= Rp 10.000,-")
                harga = 10000
            } else if (pilih == 2) {
                kendaraan = "Motor"
                println("Harga Parkir Motor/JAM = Rp 5.000,-")
                harga = 5000
            } else {
                println("Kendaraan Tidak ada")
                ulangi = 1
            }
            if (ulangi != 1) {
                print("Tanggal Masuk     : ")
                tglMasuk = input.next()
                print("Tanggal Keluar    : ")
                tglKeluar = input.next()
                print("Jam Masuk (format: 00:00)   : ")
                jamMasuk = input.next()
                print("Jam Keluar (format: 00:00)  : ")
                jamKeluar = input.next()
                bayarParkir(harga)
            }
            print("keluar? y/n :")
            quit = input.next()
        } while (quit !== "y")
    }

    fun bayarParkir(harga: Int) {

        val timeMasuk = jamMasuk!!.split(":".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val hoursMasuk = timeMasuk[0].toInt()
        val minutesMasuk = timeMasuk[1].toInt()

        val timeKeluar = jamKeluar!!.split(":".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val hoursKeluar = timeKeluar[0].toInt()
        val minutesKeluar = timeKeluar[1].toInt()

        if (hoursKeluar > 24 || hoursMasuk > 24 || minutesKeluar > 60 || minutesMasuk > 60) {
            println("Format Waktu salah")

        } else {
            var menitTotal = 0
            if (hoursMasuk > hoursKeluar) {

                val selisih = hoursMasuk - hoursKeluar
                val jamSelisih = 24 - selisih
                menitTotal = jamSelisih * 60

            } else if (hoursKeluar > hoursMasuk) {
                val selisih = hoursKeluar - hoursMasuk
                menitTotal = selisih * 60

            } else if (hoursKeluar == hoursMasuk) {
                menitTotal += 0
            }

            if (minutesMasuk > minutesKeluar) {

                val minutesAwal = 60 - minutesMasuk + minutesKeluar
                menitTotal = menitTotal + minutesAwal
                menitTotal = menitTotal - 60

            } else if (minutesKeluar > minutesMasuk) {
                val minutesAwal = minutesKeluar - minutesMasuk
                menitTotal = menitTotal + minutesAwal

            } else if (minutesKeluar == minutesMasuk) {
                menitTotal += 0
            }

            val totalJam = menitTotal / 60
            totalBayar = harga * totalJam

            if (menitTotal % 60 != 0) {
                totalBayar = totalBayar + harga
            }
            showStruk(menitTotal, totalJam)
        }
    }

    fun showStruk(menitTotal: Int, totalJam: Int) {
        println("Struk Parkir : ")
        println("Kendaraan : " + kendaraan)
        println("Tanggal Masuk   : " + tglMasuk)
        println("Tanggal Keluar  : " + tglKeluar)
        println("Jam Masuk       : " + jamMasuk)
        println("Jam Keluar      : " + jamKeluar)
        val menit = menitTotal % 60
        println("Durasi Parkir : $totalJam Jam $menit Menit")
        println("Biaya Parkir  : Rp.$totalBayar,-")
    }
}