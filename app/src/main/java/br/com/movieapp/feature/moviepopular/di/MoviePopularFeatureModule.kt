package br.com.movieapp.feature.moviepopular.di

import br.com.movieapp.feature.moviepopular.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.feature.moviepopular.data.source.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.feature.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.feature.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.feature.moviepopular.domain.usecase.GetPopularMoviesUseCase
import br.com.movieapp.feature.moviepopular.domain.usecase.GetPopularMoviesUseCaseImpl
import br.com.movieapp.framework.data.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(
        service: MovieService,
    ): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(
            service = service,
        )
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        remoteDateSource: MoviePopularRemoteDataSource,
    ): MoviePopularRepository {
        return MoviePopularRepositoryImpl(
            remoteDataSource = remoteDateSource,
        )
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(
        repository: MoviePopularRepository,
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(
            repository = repository,
        )
    }

}