package com.example.david.repository.localWithRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insertAllProducts(mProductsEntity: ProductsEntity)

    @Query("SELECT * FROM products_table")
    fun showAllProducts():LiveData<List<ProductsEntity>>

    @Query("SELECT * FROM products_table WHERE id=:mId")
    fun showOnProductById(mId: Int):LiveData<List<ProductsEntity>>
}