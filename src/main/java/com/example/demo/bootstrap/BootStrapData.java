package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository,
                         ProductRepository productRepository,
                         OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {


        long productCount = productRepository.count();
        long partCount = partRepository.count();

        if (productCount == 0 && partCount == 0) {
            loadSampleInventory();
        }

        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());

    }

    // --- Private Method to Load 5 Parts and 5 Products ---
    private void loadSampleInventory() {

        System.out.println("Loading sample Bits & Bytes inventory...");

        // ------------------------------------
        // A. Create and SAVE 5 Parts (4 Inhouse, 1 Outsourced)
        // ------------------------------------

        // Part 1: Inhouse (CPU)
        InhousePart cpuRyzen5 = new InhousePart();
        cpuRyzen5.setName("AMD Ryzen 5 CPU");
        cpuRyzen5.setPrice(199.99);
        cpuRyzen5.setInv(10);
        partRepository.save(cpuRyzen5);

        // Part 2: Outsourced (GPU)
        OutsourcedPart gpu3060 = new OutsourcedPart();
        gpu3060.setName("NVIDIA RTX 3060 GPU");
        gpu3060.setPrice(349.99);
        gpu3060.setInv(8);
        gpu3060.setCompanyName("NVIDIA Corp.");
        outsourcedPartRepository.save(gpu3060);

        // Part 3: Inhouse (RAM 16GB)
        InhousePart ram16 = new InhousePart();
        ram16.setName("16GB DDR4 RAM Kit");
        ram16.setPrice(59.99);
        ram16.setInv(20);
        partRepository.save(ram16);

        // Part 4: Inhouse (SSD)
        InhousePart ssd1tb = new InhousePart();
        ssd1tb.setName("1TB NVMe SSD");
        ssd1tb.setPrice(89.99);
        ssd1tb.setInv(15);
        partRepository.save(ssd1tb);

        // Part 5: Multi-Pack Part (RAM 32GB Multi-Pack)
        InhousePart ram32Multi = new InhousePart();
        ram32Multi.setName("32GB DDR4 RAM Kit (Multi-Pack)");
        ram32Multi.setPrice(119.99);
        ram32Multi.setInv(10);
        partRepository.save(ram32Multi);

        // ------------------------------------
        // B. Create and SAVE 5 Products
        // ------------------------------------

        // Product 1: Starter Gaming PC
        Product starterGaming = new Product("Starter Gaming PC", 899.99, 5);
        Set<Part> starterParts = new HashSet<>();
        starterParts.add(cpuRyzen5);
        starterParts.add(gpu3060);
        starterParts.add(ram16);
        starterParts.add(ssd1tb);
        starterGaming.setParts(starterParts);
        productRepository.save(starterGaming);

        // Product 2: Esports Ready PC
        Product esportsRig = new Product("Esports Ready PC", 1099.99, 4);
        Set<Part> esportsParts = new HashSet<>();
        esportsParts.add(cpuRyzen5);
        esportsParts.add(gpu3060);
        esportsParts.add(ram32Multi); // Uses the multi-pack
        esportsParts.add(ssd1tb);
        esportsRig.setParts(esportsParts);
        productRepository.save(esportsRig);

        // Product 3: Creator Workstation
        Product creatorBox = new Product("Creator Workstation", 1299.99, 3);
        Set<Part> creatorParts = new HashSet<>();
        creatorParts.add(cpuRyzen5);
        creatorParts.add(gpu3060);
        creatorParts.add(ram32Multi);
        creatorParts.add(ssd1tb);
        creatorBox.setParts(creatorParts);
        productRepository.save(creatorBox);

        // Product 4: Streaming PC
        Product streamingPC = new Product("Streaming PC", 1199.99, 3);
        Set<Part> streamingParts = new HashSet<>();
        streamingParts.add(cpuRyzen5);
        streamingParts.add(gpu3060);
        streamingParts.add(ram16);
        streamingParts.add(ssd1tb);
        streamingPC.setParts(streamingParts);
        productRepository.save(streamingPC);

        // Product 5: Office Pro Desktop
        Product officePro = new Product("Office Pro Desktop", 799.99, 6);
        Set<Part> officeParts = new HashSet<>();
        officeParts.add(cpuRyzen5);
        officeParts.add(ram16);
        officeParts.add(ssd1tb);
        officePro.setParts(officeParts);
        productRepository.save(officePro);

        System.out.println("Sample Bits & Bytes inventory loaded.");
    }
}