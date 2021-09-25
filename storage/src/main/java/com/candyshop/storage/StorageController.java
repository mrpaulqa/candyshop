package com.candyshop.storage;

import com.candyshop.candycrud.entity.Candy;
import com.candyshop.customerscrud.CustomerController;
import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.storage.entity.Storage;
import com.candyshop.storage.entity.StorageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class StorageController {
    public final static Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/storage")
    public StorageResponse getAll() {
        Storage storage = new Storage();
        storage.setQuantity(2332423L);
        storage.setReserved(432423L);
        StorageResponse storageResponse = new StorageResponse();
        storageResponse.setStorageList(Arrays.asList(storage));
        return storageResponse;
    }
    @PostMapping(path="/storage/add")
    public @ResponseBody
    String addNewStorage (@RequestBody Storage storage) {
        storage.setQuantity(2332423L);
        storage.setReserved(432423L);
        return "Saved";
    }

    @PutMapping(value = "/storage/update/{id}")
    public Storage updateStorage(@PathVariable Integer id,@RequestBody Storage storage){
        storage.setQuantity(2332423L);
        storage.setReserved(432423L);
        LOGGER.info(storage.toString());
        return storage;
    }

    @DeleteMapping(value = "/storage/delete/{id}")
    public String deleteStorage(@PathVariable Integer id){
        getAll().getStorageList().remove(id);
        return "Deleted candy with id: "+id;
    }

    @PatchMapping(value = "/storage/patch/{id}")
    public @ResponseBody String updateStoragePartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){

        return "";
    }

}
