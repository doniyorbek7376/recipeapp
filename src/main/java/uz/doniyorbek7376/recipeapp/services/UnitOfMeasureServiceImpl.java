package uz.doniyorbek7376.recipeapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import uz.doniyorbek7376.recipeapp.commands.UnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.repositories.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository uomRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository uomRepository,
            UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomRepository = uomRepository;
        this.uomConverter = uomConverter;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        Set<UnitOfMeasureCommand> uoms = new HashSet<>();
        uomRepository.findAll().forEach(uom -> uoms.add(uomConverter.convert(uom)));
        return uoms;
    }

}
