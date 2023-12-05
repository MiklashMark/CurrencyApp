package by.bsuir.markMiklash.currencyApp.dao.api;

import by.bsuir.markMiklash.currencyApp.dao.entity.ConverterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ICurrencyConverterDao extends CrudRepository<ConverterEntity, UUID> {
}
