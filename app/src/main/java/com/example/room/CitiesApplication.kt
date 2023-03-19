package com.example.room

import android.app.Application
import com.example.room.db.Db
import com.example.room.db.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CitiesApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { Db.getDatabase(this, applicationScope) }
    val repository by lazy { Repository(database.citydao()) }
}