package com.yagiz.inventoryservice.business.abstracts;

import com.yagiz.inventoryservice.business.dtos.requests.create.CreateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateBrandRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetBrandResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    GetBrandResponse getBrandById(int brandId);
    List<GetBrandListResponse> getBrandList();
    void deleteBrandById(int brandId);
}
