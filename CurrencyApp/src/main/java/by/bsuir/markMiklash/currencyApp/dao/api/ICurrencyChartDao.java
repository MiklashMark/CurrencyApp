package by.bsuir.markMiklash.currencyApp.dao.api;

import by.bsuir.markMiklash.currencyApp.dao.entity.ChartEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ICurrencyChartDao extends CrudRepository<ChartEntity, UUID> {
}
