package com.capstone.eratani.utils

import com.capstone.eratani.model.ModelEntity

object DataDummy {
    fun generateDummyMonitor(): List<ModelEntity> {
        val monitor = ArrayList<ModelEntity>()
        monitor.add(ModelEntity("399579",
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido.",
            "13.3",
            "32.4",
            "11"))
        monitor.add(ModelEntity("297802",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm.",
            "35.2",
            "23.4",
            "12"))
        return monitor
    }
}