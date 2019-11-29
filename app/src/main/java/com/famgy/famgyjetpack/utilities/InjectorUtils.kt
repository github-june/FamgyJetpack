/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.famgy.famgyjetpack.utilities

import android.content.Context
import com.famgy.famgyjetpack.data.AppDatabase
import com.famgy.famgyjetpack.data.repository.GardenPlantingRepository
import com.famgy.famgyjetpack.data.repository.PlantRepository
import com.famgy.famgyjetpack.data.repository.SongRepository
import com.famgy.famgyjetpack.viewmodels.factory.GardenPlantingListViewModelFactory
import com.famgy.famgyjetpack.viewmodels.factory.PlantDetailViewModelFactory
import com.famgy.famgyjetpack.viewmodels.factory.PlantListViewModelFactory
import com.famgy.famgyjetpack.viewmodels.factory.SongListViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return GardenPlantingListViewModelFactory(repository)
    }

    fun providePlantListViewModelFactory(context: Context): PlantListViewModelFactory {
        val repository = getPlantRepository(context)
        return PlantListViewModelFactory(repository)
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(getPlantRepository(context),
                getGardenPlantingRepository(context), plantId)
    }

    fun provideSongListViewModelFactory(context: Context): SongListViewModelFactory {
        val repository = getSongRepository(context)
        return SongListViewModelFactory(repository)
    }


    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).plantDao())
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    private fun getSongRepository(context: Context): SongRepository {
        return SongRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).songDao()
        )
    }
}