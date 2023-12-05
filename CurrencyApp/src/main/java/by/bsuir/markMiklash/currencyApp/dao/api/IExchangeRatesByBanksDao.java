package by.bsuir.markMiklash.currencyApp.dao.api;

import by.bsuir.markMiklash.currencyApp.dao.entity.ExchangeRateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IExchangeRatesByBanksDao extends CrudRepository<ExchangeRateEntity, UUID> {
}
