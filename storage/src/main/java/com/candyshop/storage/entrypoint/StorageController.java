package com.candyshop.storage.entrypoint;

import com.candyshop.storage.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class StorageController {
    public final static Logger LOGGER = Logger.getLogger(StorageController.class.getName());

    @Autowired
    private CandyService candyService;

    @GetMapping(path="/storage/{id}")
    public Storage get(@PathVariable Integer id){
        Storage s = new Storage();
        s.setId(1L);
//        s.(this.candyService.getAllCandies().getStorages());
        return s;
    }

    //Just an example
    @PatchMapping(path="/storage/{id}")
    public Storage borrow(@PathVariable Integer id, @RequestBody Map<String, Object> body) {
        body.containsKey("amount");
        body.get("amount");
        //...
        return null;
    }

//    @GetMapping(path="/project/{id}")
//    public Project get(@PathVariable Integer id){
//        Project p = new Project();
//        p.setId(id);
//        p.setIllegible(this.personService.getAllPeople().getPeople());
//        return p;
//    }
//    @GetMapping("/storage")
//    public StorageResponse getAll() {
//        Storage storage = new Storage();
//        storage.setQuantity(2332423L);
//        storage.setReserved(432423L);
//        StorageResponse storageResponse = new StorageResponse();
//        storageResponse.setStorageList(Arrays.asList(storage));
//        return storageResponse;
//    }
//    @PostMapping(path="/storage/add")
//    public @ResponseBody
//    String addNewStorage (@RequestBody Storage storage) {
//        storage.setQuantity(2332423L);
//        storage.setReserved(432423L);
//        return "Saved";
//    }

//    @PutMapping(value = "/storage/update/{id}")
//    public Storage updateStorage(@PathVariable Integer id,@RequestBody Storage storage){
//        storage.setQuantity(2332423L);
//        storage.setReserved(432423L);
//        LOGGER.info(storage.toString());
//        return storage;
//    }

//    @DeleteMapping(value = "/storage/delete/{id}")
//    public String deleteStorage(@PathVariable Integer id){
//        getAll().getStorageList().remove(id);
//        return "Deleted candy with id: "+id;
//    }

//    @PatchMapping(value = "/storage/patch/{id}")
//    public @ResponseBody String updateStoragePartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){
//
//        return "";
//    }

}
