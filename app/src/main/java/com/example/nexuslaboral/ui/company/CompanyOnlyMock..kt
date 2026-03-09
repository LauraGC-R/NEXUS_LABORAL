package com.example.nexuslaboral.ui.company

object CompanyOnlyMock {

    // Videos (IDs de YouTube)
    // Servicios (short)
    const val VIDEO_SERVICIOS = "3kUFk_JXOTw" // “Nuestros servicios - Conmersa” :contentReference[oaicite:0]{index=0}
    // Servicios (otro short, por si quieres alternar)
    const val VIDEO_SERVICIOS_2 = "pBbs-nl0zls" // “Conoce nuestros servicios // Conmersa” :contentReference[oaicite:1]{index=1}

    // Site Santa Catarina (tu link)
    const val VIDEO_SITE_SC = "W2YAQUmbSQk" // tu video compartido (ID)

    fun whatCompanyDoesText(): String {
        return "Soluciones de empaque y embalaje para clientes: armado de promociones, etiquetado y re-etiquetado, " +
                "manejo de líneas operativas y servicios a la medida con enfoque en calidad y mejora continua."
    }

    fun servicesBullets(): List<String> = listOf(
        "Armado de promociones y paquetes especiales",
        "Etiquetado y re-etiquetado (promocional o cumplimiento)",
        "Manejo de líneas operativas (outsourcing)",
        "Empaque / embalaje / reempaque según necesidad",
        "Procesos estandarizados y mejora continua (BPM)"
    )

    fun siteText(): String {
        return "Parque Industrial Las Palmas\n" +
                "Site Santa Catarina, N.L.\n" +
                "Dirección: Palmas No. 130, Parque Industrial Las Palmas, Santa Catarina, N.L., C.P. 66367."
    }
}