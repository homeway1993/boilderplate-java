package boilerplate.springboot.multiplemongodb.repository.secondary;

import boilerplate.springboot.multiplemongodb.entity.secondary.Item;

public interface ItemRepositoryCustom {

    Item findFirst();
}
