package com.sound.wave.repository;

import com.sound.wave.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
  Song findSongById(Long id);

  @Query(value = "select * from song r where r.user_id = :id", nativeQuery = true)
  Iterable<Song> findAllByUserId(@Param("id") Long id);

  @Transactional
  @Modifying
  @Query(value = "UPDATE song s set views = views + 1 where s.id = :id", nativeQuery = true)
  void updateViews(@Param("id") Long id);

  @Query(value = "select * from song s order by views desc limit 10", nativeQuery = true)
  Iterable<Song> findSongsByMostViews();

  @Query(value = "select * from song s order by date_create desc limit 10", nativeQuery = true)
  Iterable<Song> findSongsByDateNew();

  @Query(value = "select s.* from song as s \n" +
    "join (select ls.song_id as id, count(ls.user_id) as soluong from like_song as ls where ls.status=0 group by ls.song_id order by soluong desc)\n" +
    " as ok on s.id= ok.id\n" +
    "limit 10", nativeQuery = true)
  Iterable<Song> findSongsByMostLike();

  Iterable<Song> findAllByNameContaining(String name);

  @Query(value = "select * from song " +
    "order by song.date_create desc " +
    "limit 10", nativeQuery = true)
  Iterable<Song> findSongsByDateNewLimit10();

  @Query(value = "SELECT * FROM song as s where s.category_id= :id", nativeQuery = true)
  Iterable<Song> findSongsByCategoryId(@Param("id") Long id);

  @Query(value = "select * from song \n" +
    "where song.id in ( select ls.song_id from like_song as ls \n" +
    "where ls.user_id =?1 and ls.status= 0)", nativeQuery = true)
  Iterable<Song> findSongsByUserIdAndStatus(Long id);

  @Modifying
  @Query(value = "select s.* from song as s \n" +
    "            join song_playlist as sp on s.id = sp.song_id \n" +
    "            join play_list as p on p.id = sp.play_list_id \n" +
    "            where p.id = :id", nativeQuery = true)
  List<Song> findSongsByPlaylistID(@Param("id") Long id);

  @Query(value = "SELECT * from song as s where not s.id= ?1 ", nativeQuery = true)
  Iterable<Song> findSongsBySubId(Long id);

  @Query(value = "select * from song as s where s.id not in (select s.id from song as s \n" +
    "                    join song_playlist as sp on s.id = sp.song_id \n" +
    "                        join play_list as p on p.id = sp.play_list_id \n" +
    "                        where p.id = ?1)", nativeQuery = true)
  Iterable<Song> findSongsHaveNotInPlaylist(Long id);

  Iterable<Song> findSongsByCategoryName(String name);

}
