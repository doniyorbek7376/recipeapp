package uz.doniyorbek7376.recipeapp.services;

import java.util.Set;

import uz.doniyorbek7376.recipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

}
