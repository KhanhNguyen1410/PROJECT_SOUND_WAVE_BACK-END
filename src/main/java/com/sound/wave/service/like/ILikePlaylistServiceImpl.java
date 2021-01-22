package com.sound.wave.service.like;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.repository.like.ILikePlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ILikePlaylistServiceImpl implements ILikePlaylistService{
    @Autowired
    private ILikePlaylistRepository iLikePlaylistRepository;
    @Override
    public Iterable<LikePlaylist> findAll() {
        return null;
    }

    @Override
    public LikePlaylist save(LikePlaylist likePlaylist) {
        return null;
    }

    @Override
    public Optional<LikePlaylist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Long findLikeByPlaylistId(Long id) {
        return iLikePlaylistRepository.findLikeByPlaylistId(id);
    }

    @Override
    public LikePlaylist checkLikePlaylist(Long p_id, Long u_id) {
        return iLikePlaylistRepository.checkLikePlaylist(p_id, u_id);
    }

    @Override
    public Iterable<PlayList> findPlaylistsByUserIdAndStatus(Long id) {
        return iLikePlaylistRepository.findPlaylistsByUserIdAndStatus(id);
    }
}
