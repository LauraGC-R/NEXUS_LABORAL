package com.example.nexuslaboral.ui.company

data class CompanyVideo(
    val title: String,
    val tag: String,      // "Inducción", "Seguridad", "Servicios", etc.
    val youtubeId: String // lo que va después de v= o /shorts/
)

data class CompanyService(
    val title: String,
    val tag: String,      // BPM / Calidad / Operación / Seguridad
    val desc: String,
    val minutes: Int,
    val progress: Int,
    val youtubeId: String
)

data class CompanyInfo(
    val title: String,
    val bullets: List<String>
)