package com.example.lab1

class FuelCompositionCalculator {
    fun calculateComposition(hp: Double, cp: Double, sp: Double, np: Double, op: Double, wp: Double, ap: Double): String {
        val krs = 100.0 / (100.0 - wp)
        val krg = 100.0 / (100.0 - wp - ap)
        val hc = hp * krs
        val cc = cp * krs
        val sc = sp * krs
        val nc = np * krs
        val oc = op * krs
        val ac = ap * krs
        val hg = hp * krg
        val cg = cp * krg
        val sg = sp * krg
        val ng = np * krg
        val og = op * krg
        val qrn = 339 * cp + 1030 * hp - 108.8 * (op - sp) - 25 * wp
        val qdn = qrn / (1 - 0.01 * wp)
        val qdafn = qrn / (1 - 0.01 * (wp + ap))

        return buildString {
            appendLine("Коефіцієнт переходу від робочої до сухої маси: ${"%.2f".format(krs)}")
            appendLine("Коефіцієнт переходу від робочої до горючої маси: ${"%.2f".format(krg)}")
            appendLine("\nСклад сухої маси палива:")
            appendLine("H_C = ${"%.2f".format(hc)}%, C_C = ${"%.2f".format(cc)}%, S_C = ${"%.2f".format(sc)}%")
            appendLine("N_C = ${"%.3f".format(nc)}%, O_C = ${"%.2f".format(oc)}%, A_C = ${"%.2f".format(ac)}%")
            appendLine("\nСклад горючої маси палива:")
            appendLine("H_G = ${"%.2f".format(hg)}%, C_G = ${"%.2f".format(cg)}%, S_G = ${"%.2f".format(sg)}%")
            appendLine("N_G = ${"%.3f".format(ng)}%, O_G = ${"%.2f".format(og)}%")
            appendLine("\nНижча теплота згоряння:")
            appendLine("Для робочої маси: ${"%.4f".format(qrn / 1000)} МДж/кг")
            appendLine("Для сухої маси: ${"%.4f".format(qdn / 1000)} МДж/кг")
            appendLine("Для горючої маси: ${"%.4f".format(qdafn / 1000)} МДж/кг")
        }
    }
}