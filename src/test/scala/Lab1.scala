import spatial.dsl._


@spatial class loadcsv2d extends SpatialTest {
    
  type T = FixPt[TRUE,_16,_16]

  def main(args: Array[String]): Unit = {
    
    // These are on the HOST
    val A_host = loadCSV2D[T](s"$DATA/mat.csv")
    val A_dram = DRAM[T](5,2)
    setMem(A_dram, A_host)
    
    val a_mat = getMatrix(A_dram)
    printMatrix(a_mat)
    writeCSV2D(a_mat, s"$DATA/output.csv")
    assert(Bit(true))
  }
}
