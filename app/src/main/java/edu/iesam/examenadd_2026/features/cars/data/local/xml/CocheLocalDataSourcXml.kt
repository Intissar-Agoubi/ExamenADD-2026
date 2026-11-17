package edu.iesam.examenadd_2026.features.cars.data.local.xml

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examenadd_2026.R
import edu.iesam.examenadd_2026.core.cache.AppCache
import edu.iesam.examenadd_2026.core.serialization.JsonSerialiser
import edu.iesam.examenadd_2026.features.cars.domain.Coche

class CocheLocalDataSourcXml(private val context: Context, private val gson: Gson = Gson(), private val appCache: AppCache, private val serialiser: JsonSerialiser<List<Coche>>) {
    private val ttl = 2 * 60* 1000L
    private val keyCoches = "KeyCoches"
    private val sharedPreferences = context.getSharedPreferences(context.getString(R.string.local_data_source),
        Context.MODE_PRIVATE)
    // guardar todas las coches
    fun saveAll(coche: List<Coche>){
        sharedPreferences.edit().putString(keyCoches,serialiser.toJson(coche)).apply()
        appCache.updateTime(keyCoches)
    }
    // recuperar todas las coches
    fun findAll(): List<Coche>{
        if (appCache.isExpired(keyCoches,ttl))return emptyList()
        val json = sharedPreferences.getString(keyCoches, null)?: return emptyList()
        return serialiser.fromJson(json)
    }
    // eliminar a traves su id
    fun deleteById(id: String){
        return saveAll(findAll().filterNot { it.propietario.dni== id  })
    }
    fun deleteAll(){
        sharedPreferences.edit().remove(keyCoches).apply()
    }

}