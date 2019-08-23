package com.codeChallanges;

import java.util.*;

/*
Pop quiz hot shot.
        Lately at my 9-5 job we have been struggling with our server / DB performance.
        This problem is absolutely not specific to the company I work for though.
        Performance problems are a plague in any enterprise business, mostly due to high volume of traffic and high volume of stored data.
        I learned a lot last week when I was assigned the task to improve the performance of a batch job that runs daily, and took over 8 hours to complete.
        Long story short, I managed to reduce the length of job to about 8 minutes (instead of 8 hours).
        How the heck did I do it?
        That's what I want to quiz you on today.
        Here's an example of the code I had to fix (this will be pseudo-ish code):
*/

//Let's assume there are 1,000,000+ item in this list items
//-------------------Example Code Given via Coder Campus---------------------------
public class FindItem {
    public void findItems() {
        for (List<Item> item : items) {
            if (item.getPropert1().equals("Some_CONSTANT")) {
                continue;
            }
            If(item.getProperty2() == null) {
                continue;
            }
        }
            //setting otherItem to the found item via id
        OtherItem otherItem = someOtherItemRepository.findById(item.getId());

        //We then check for null value and if is not null delete this item then save
        if (otherItem != null) {
            item.setDeleted("Y");
            itemRepository.save(item);
            continue;
        }

         otherItem = someOtherItemRepository.findByProperty1AndPropert2(item.getPropert1(), item.getProperty2);

        if (otherItem != null) {
            continue;
        }

        item.setCreatedDate(new Date());
        item.setUpdatedDate(new Date());

        itemRepository.save;
    }

//My thoughts
//Use a HashSet, would be much faster

public void useHashSet(){
    Set<Item> items = new HashSet<>();
    Item newItem = new Item();
    newItem.setProperty1("G");
    newItem.setPropert2("H");
    items.add(newItem);

    //Iterating over a HashSet of items would be much faster
    OtherItem otherItem = new OtherItem();

    for(Item item : items) {
      if(item.getProperty1().contains("SOME_CONSTANT") && item.getPropert2().isEmpty()){
          otherItem = someOtherItemRepo.findBuId(item.getId());
      }
    }
}
}


//---------------My Solution/changes to the orginal-----------------------


public class FindItem {
    public void findItems() {
       OtherItem otherItem = new OtherItem();
        for (List<Item> item : items) {
            if (item.getPropert1().equals("Some_CONSTANT") && item.getProperty2() == null) {
                otherItem = someOtherItemRepository.findById(item.getId());
            }

            if (otherItem != null) {
                item.setDeleted("Y");
                itemRepository.save(item);
                continue;
            }
            //-----We already have otherItem found by ID why check null twice or retrieve from the DB a 2nd time?
           // otherItem = someOtherItemRepository.findByProperty1AndPropert2(item.getPropert1(),item.getProperty2);

           /* if (otherItem != null) {
                continue;
            }*/
           
            item.setCreatedDate(new Date());
            item.setUpdatedDate(new Date());

            itemRepository.save;
        }
    }
}

//Will get the solution tomorrow