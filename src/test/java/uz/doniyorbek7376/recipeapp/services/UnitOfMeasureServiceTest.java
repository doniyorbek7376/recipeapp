package uz.doniyorbek7376.recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import uz.doniyorbek7376.recipeapp.commands.UnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.domain.UnitOfMeasure;
import uz.doniyorbek7376.recipeapp.repositories.UnitOfMeasureRepository;

public class UnitOfMeasureServiceTest {

    UnitOfMeasureService uomService;

    @Mock
    UnitOfMeasureRepository uomRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        uomService = new UnitOfMeasureServiceImpl(uomRepository, new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testGetUomList() throws Exception {
        // given
        Set<UnitOfMeasure> uoms = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        uoms.add(uom1);
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setId(2L);
        uoms.add(uom2);
        // when
        when(uomRepository.findAll()).thenReturn(uoms);

        Set<UnitOfMeasureCommand> result = uomService.listAllUoms();

        assertEquals(2, result.size());
        verify(uomRepository, times(1)).findAll();

    }
}
