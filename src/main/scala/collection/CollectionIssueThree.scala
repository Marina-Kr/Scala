package collection

import scala.collection.mutable.ListBuffer
import scala.Console.println

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */

object CollectionIssueThree {

  def main(args: Array[String]): Unit = {

    val source = io.Source.fromFile("src/hdata_stock.csv")
    val rows = ListBuffer[(String, Double, Double, Double, Double)]()

    for (line <- source.getLines.slice(1, 201)) {
      val Array(column1, column2, column3, column4, column5) = line.split(";").map(_.trim)
      rows += Tuple5(column1, column2.toDouble, column3.toDouble, column4.toDouble, column5.toDouble)
    }

    val days = rows.length
    val google = (math floor (rows.map(_._2).sum / days) * 100) / 100
    val microsoft = (math floor (rows.map(_._3).sum / days) * 100) / 100
    val amazon = (math floor (rows.map(_._4).sum / days) * 100) / 100
    val facebook = (math floor (rows.map(_._5).sum / days) * 100) / 100
    println(s"Google - $google")
    println(s"Microsoft - $microsoft")
    println(s"Amazon - $amazon")
    println(s"Facebook - $facebook")

//    val list_prices = rows
//
//    list_prices.foreach(y => {
//      println(y)
//    })

    source.close

  }
}


