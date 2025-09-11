package dev.tiagosilva;

import dev.tiagosilva.dto.*;
import dev.tiagosilva.controller.*;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
                    config.router.mount(router -> {})
                        .apiBuilder(() -> {

                            path("user", () -> {
                                UserController ctrl = new UserController() {};
                                path("", () -> {
                                    get(ctx -> {
                                        List<UserDTO> userDTOList = ctrl.get();
                                        ctx.status(200);
                                        ctx.json(userDTOList);
                                    });
                                    post(ctx -> {
                                        UserDTO userDTO = ctrl.create(ctx.bodyAsClass(UserDTO.class));
                                        userDTO.setId(3L);
                                        ctx.json(userDTO);
                                    });
                                });
                                path("{id}", () -> {
                                    get(ctx -> {
                                        UserDTO userDTO = ctrl.get(Long.valueOf(ctx.pathParam("id")));
                                        ctx.status(200);
                                        ctx.json(userDTO);
                                    });
                                    put(ctx -> {
                                        UserDTO userDTO = ctrl.update(Long.valueOf(ctx.pathParam("id")), ctx.bodyAsClass(UserDTO.class));
                                        ctx.status(200);
                                        ctx.json(userDTO);
                                    });
                                    delete(ctx -> {
                                        boolean result = ctrl.delete(Long.valueOf(ctx.pathParam("id")));
                                        if (result) {
                                            ctx.status(200);
                                            ctx.json("Ok");
                                        }
                                        else {
                                            ctx.status(400);
                                            ctx.json("Error");
                                        }
                                    });
                                });
                            });
                            path("address", () -> {
                                AddressController ctrl = new AddressController() {};
                                path("", () -> {
                                    get(ctx -> {
                                        List<AddressDTO> addressDTOList = ctrl.get();
                                        ctx.status(200);
                                        ctx.json(addressDTOList);
                                    });
                                    post(ctx -> {
                                        AddressDTO addressDTO = ctrl.create(ctx.bodyAsClass(AddressDTO.class));
                                        ctx.json(addressDTO);
                                    });
                                });
                                path("{id}", () -> {
                                    get(ctx -> {
                                        AddressDTO addressDTO = ctrl.get(Long.valueOf(ctx.pathParam("id")));
                                        ctx.status(200);
                                        ctx.json(addressDTO);
                                    });
                                    put(ctx -> {
                                        AddressDTO addressDTO = ctrl.update(Long.valueOf(ctx.pathParam("id")), ctx.bodyAsClass(AddressDTO.class));
                                        ctx.status(200);
                                        ctx.json(addressDTO);
                                    });
                                    delete(ctx -> {
                                        boolean result = ctrl.delete(Long.valueOf(ctx.pathParam("id")));
                                        if (result) {
                                            ctx.status(200);
                                            ctx.json("Ok");
                                        }
                                        else {
                                            ctx.status(400);
                                            ctx.json("Error");
                                        }
                                    });
                                });
                            });
                            path("product", () -> {
                                ProductController ctrl = new ProductController() {};
                                path("", () -> {
                                    get(ctx -> {
                                        List<ProductDTO> productDTOList = ctrl.get();
                                        ctx.status(200);
                                        ctx.json(productDTOList);
                                    });
                                    post(ctx -> {
                                        ProductDTO productDTO = ctrl.create(ctx.bodyAsClass(ProductDTO.class));
                                        ctx.json(productDTO);
                                    });
                                });
                                path("{id}", () -> {
                                    get(ctx -> {
                                        ProductDTO productDTO = ctrl.get(Long.valueOf(ctx.pathParam("id")));
                                        ctx.status(200);
                                        ctx.json(productDTO);
                                    });
                                    put(ctx -> {
                                        ProductDTO productDTO = ctrl.update(Long.valueOf(ctx.pathParam("id")), ctx.bodyAsClass(ProductDTO.class));
                                        ctx.status(200);
                                        ctx.json(productDTO);
                                    });
                                    delete(ctx -> {
                                        boolean result = ctrl.delete(Long.valueOf(ctx.pathParam("id")));
                                        if (result) {
                                            ctx.status(200);
                                            ctx.json("Ok");
                                        }
                                        else {
                                            ctx.status(400);
                                            ctx.json("Error");
                                        }
                                    });
                                });
                            });
                            path("order", () -> {
                                OrderController ctrl = new OrderController() {};
                                path("", () -> {
                                    get(ctx -> {
                                        List<OrderDTO> oderDTOList = ctrl.get();
                                        ctx.status(200);
                                        ctx.json(oderDTOList);
                                    });
                                    post(ctx -> {
                                        OrderDTO orderDTO = ctrl.create(ctx.bodyAsClass(OrderDTO.class));
                                        ctx.json(orderDTO);
                                    });
                                });
                                path("{id}", () -> {
                                    get(ctx -> {
                                        OrderDTO orderDTO = ctrl.get(Long.valueOf(ctx.pathParam("id")));
                                        ctx.status(200);
                                        ctx.json(orderDTO);
                                    });
                                    put(ctx -> {
                                        OrderDTO orderDTO = ctrl.update(Long.valueOf(ctx.pathParam("id")), ctx.bodyAsClass(OrderDTO.class));
                                        ctx.status(200);
                                        ctx.json(orderDTO);
                                    });
                                    delete(ctx -> {
                                        boolean result = ctrl.delete(Long.valueOf(ctx.pathParam("id")));
                                        if (result) {
                                            ctx.status(200);
                                            ctx.json("Ok");
                                        }
                                        else {
                                            ctx.status(400);
                                            ctx.json("Error");
                                        }
                                    });
                                });
                            });
                            path("payment", () -> {
                                PaymentController ctrl = new PaymentController() {};
                                path("", () -> {
                                    get(ctx -> {
                                        List<PaymentDTO> paymentDTOList = ctrl.get();
                                        ctx.status(200);
                                        ctx.json(paymentDTOList);
                                    });
                                    post(ctx -> {
                                        PaymentDTO paymentDTO = ctrl.create(ctx.bodyAsClass(PaymentDTO.class));
                                        ctx.json(paymentDTO);
                                    });
                                });
                                path("{id}", () -> {
                                    get(ctx -> {
                                        PaymentDTO paymentDTO = ctrl.get(Long.valueOf(ctx.pathParam("id")));
                                        ctx.status(200);
                                        ctx.json(paymentDTO);
                                    });
                                    put(ctx -> {
                                        PaymentDTO paymentDTO = ctrl.update(Long.valueOf(ctx.pathParam("id")), ctx.bodyAsClass(PaymentDTO.class));
                                        ctx.status(200);
                                        ctx.json(paymentDTO);
                                    });
                                    delete(ctx -> {
                                        boolean result = ctrl.delete(Long.valueOf(ctx.pathParam("id")));
                                        if (result) {
                                            ctx.status(200);
                                            ctx.json("Ok");
                                        }
                                        else {
                                            ctx.status(400);
                                            ctx.json("Error");
                                        }
                                    });
                                });
                            });
                            path("report", () -> {});
                        });
                })
                .get("/status", ctx -> ctx.result("API is running..."))
                .start(8000);
    }
}