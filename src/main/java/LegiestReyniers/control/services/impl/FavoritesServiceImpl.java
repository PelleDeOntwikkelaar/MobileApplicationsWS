package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Favorit;
import LegiestReyniers.repositories.FavoritRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FavoritesServiceImpl {

    @Resource
    FavoritRepository favoritRepository;

    public void addToFavorites(String stationUri, int userId){
        Favorit favorit = new Favorit();
        favorit.setStation_uri(stationUri);
        favorit.setUserid(userId);
        favoritRepository.save(favorit);
    }

}
