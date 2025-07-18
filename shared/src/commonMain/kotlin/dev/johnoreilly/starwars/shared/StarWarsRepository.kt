package dev.johnoreilly.starwars.shared

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.cache.normalized.watch
import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import dev.johnoreilly.starwars.GetAllFilmsQuery
import dev.johnoreilly.starwars.GetAllPeopleQuery
import dev.johnoreilly.starwars.fragment.FilmFragment
import dev.johnoreilly.starwars.fragment.FilmFragmentImpl_ResponseAdapter
import dev.johnoreilly.starwars.fragment.PersonFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import okio.IOException
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StarWarsRepository: KoinComponent {
    @NativeCoroutineScope
    val coroutineScope: CoroutineScope = MainScope()

    private val apolloClient: ApolloClient by inject()

    @NativeCoroutines
    val people: Flow<List<PersonFragment>> = apolloClient.query(GetAllPeopleQuery()).watch()
        .filter {
            it.exception == null
        }
        .map {
            it.dataOrThrow().allPeople.people.mapNotNull { it?.personFragment }
    }

    @NativeCoroutines
    val films: Flow<List<FilmFragment>> = apolloClient.query(GetAllFilmsQuery()).watch()
        .filter { it.exception == null }
        .map { it.dataOrThrow().allFilms.films.mapNotNull { it?.filmFragment }
    }

    suspend fun prefetch() {
        prefetch(GetAllPeopleQuery())
        prefetch(GetAllFilmsQuery())
    }

    private suspend fun prefetch(query: Query<*>) {
//        try {
//            apolloClient.query(query).execute()
//        } catch (ioe: IOException) {
//            // ignore prefetch failure
//        }
    }
}