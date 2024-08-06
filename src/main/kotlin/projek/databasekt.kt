package projek

import java.util.Scanner

object Data {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = Database()
        app.menu()
    }
}

class Database {
    private val input = Scanner(System.`in`)
    private val dataEntries = mutableListOf<DataEntry>()

    fun menu() {
        var quit: String

        do {
            println("======================")
            println("== Input and List ==")
            println("======================")
            println("1. Input Data ")
            println("2. List ")
            println("3. Remove List")
            println("===================")
            print("Pilih Menu = ")
            when (val pilih = input.nextInt()) {
                1 -> inputData()
                2 -> listData()
                3 -> removeData()
                else -> println("Pilihan tidak valid")
            }
            println("================")
            print("Keluar? (y/n) = ")
            quit = input.next()
        } while (quit == "n")
    }

    private fun inputData() {
        do {
            print("Nama = ")
            val nama = input.next()

            if (dataEntries.any { it.nama == nama }) {
                println("Nama sudah terdaftar.")
            } else {
                val newData = DataEntry(nama)
                dataEntries.add(newData)
                println("Data telah ditambahkan.")
            }

            print("Tambahkan nama lagi? (y/n): ")
        } while (input.next() != "n")
    }

    private fun listData() {
        if (dataEntries.isEmpty()) {
            println("Tidak ada data yang tersedia.")
        } else {
            println("===================")
            println(" == LIST DATA == ")
            println("===================")
            dataEntries.forEachIndexed { index, data ->
                println("Nama: ${data.nama}")
//                println("Tanggal Lahir: ${data.tanggalLahir}")
//                println("Alamat: ${data.alamat}")
                println()
            }
        }
    }

    private fun removeData() {
        if (dataEntries.isEmpty()) {
            println("Tidak ada data yang tersedia untuk dihapus.")
        } else {
            listData()
            print("Masukkan nomor data yang ingin dihapus: ")
            val indexToRemove = input.nextInt() - 1
            if (indexToRemove in dataEntries.indices) {
                dataEntries.removeAt(indexToRemove)
                println("Data telah dihapus.")
            } else {
                println("Nomor data tidak valid.")
            }
        }
    }
}

data class DataEntry(val nama: String)