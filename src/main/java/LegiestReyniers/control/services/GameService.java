package LegiestReyniers.control.services;

import LegiestReyniers.repositories.GameRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GameService {

    @Resource
    private GameRepository gameRepository;
}
