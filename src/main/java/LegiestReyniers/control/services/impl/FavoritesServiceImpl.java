package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Favorit;
import LegiestReyniers.repositories.FavoritRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

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

    public boolean isFavorit(String stationCode, int parseInt) {
        Iterable<Favorit> favorits=favoritRepository.findByUserid(parseInt);
        Favorit favoritOutput=null;
        for(Favorit favorit:favorits){
            if(favorit.getStation_uri().equals(stationCode)){
                favoritOutput=favorit;
            }
        }
        if( favoritOutput==null) return false;
        else return true;
    }
}
