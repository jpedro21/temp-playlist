package com.app.tempplaylist;

import com.app.tempplaylist.dto.*;
import com.app.tempplaylist.service.*;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TempPlaylistSearchTempPlaylistApplicationTests {

	@InjectMocks
	private TempPlaylistServer tempPlaylistServer;

	@Mock
	private WeatherService weatherService;

	@Mock
	private PlaylistService playlistService;


	@Test
	public void failLocaleWithNumber() {

	}

	@Test
	public void failLatLonWithString() {

	}

	@Test
	public void successMaxPop() {
        when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(30D));
        when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

        final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
        assertEquals("POP", playlist.getType());
        assertTrue(playlist.getData().size() > 0);

		ReflectionTestUtils
	}

	@Test
	public void successMinPop() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(15D));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("POP", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMaxClassic() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(9D));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("CLASSIC", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMinClassic() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(Double.MIN_VALUE));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("CLASSIC", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMaxRock() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(14D));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("ROCK", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMinRock() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(10D));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("ROCK", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMaxParty() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(Double.MAX_VALUE));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("PARTY", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void successMinParty() {
		when(weatherService.getTempByLocale(anyString())).thenReturn(new WeatherDto(31D));
		when(playlistService.getPlaylistByGenre(any())).thenReturn(Sets.newHashSet(playListExample()));

		final DataDto<Set<MusicDto>> playlist = tempPlaylistServer.tempPlaylist(anyString());
		assertEquals("PARTY", playlist.getType());
		assertTrue(playlist.getData().size() > 0);
	}

	@Test
	public void noMusicsWereFound() {

	}

	private final MusicDto playListExample() {
		AlbumDto album = new AlbumDto();
		album.setName("Album");

		ArtistsDto artist = new ArtistsDto();
		artist.setName("Artist");

		MusicDto music = new MusicDto();
		music.setName("PlayList");
		music.setAlbum(album);
		music.setArtists(Sets.newHashSet(artist));

		return music;
	}
}
