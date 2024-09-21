package com.example.lab1

class MazutCalculator {
    fun calculateMazutComposition(
        carbonG: Double, hydrogenG: Double, oxygenG: Double, sulfurG: Double,
        heatValueG: Double, moistureP: Double, ashD: Double, vanadiumG: Double
    ): String {
        val factor = (100 - moistureP - ashD) / 100

        val carbonP = carbonG * factor
        val hydrogenP = hydrogenG * factor
        val oxygenP = oxygenG * factor
        val sulfurP = sulfurG * factor
        val ashP = ashD * (100 - moistureP) / 100
        val vanadiumP = vanadiumG * (100 - moistureP) / 100

        val heatValueP = heatValueG * (1 - 0.01 * (moistureP + ashP))

        return buildString {
            appendLine("Склад робочої маси мазуту:")
            appendLine("Вуглець (C): ${"%.2f".format(carbonP)}%")
            appendLine("Водень (H): ${"%.2f".format(hydrogenP)}%")
            appendLine("Кисень (O): ${"%.2f".format(oxygenP)}%")
            appendLine("Сірка (S): ${"%.2f".format(sulfurP)}%")
            appendLine("Зола (A): ${"%.2f".format(ashP)}%")
            appendLine("Ванадій (V): ${"%.2f".format(vanadiumP)} мг/кг")
            appendLine("\nНижча теплота згоряння мазуту на робочу масу:")
            appendLine("${"%.2f".format(heatValueP)} МДж/кг")
        }
    }
}