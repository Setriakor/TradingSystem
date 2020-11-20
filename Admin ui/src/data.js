import React from "react";
import Faker from "faker";
import Assessment from "@material-ui/icons/Assessment";
import GridOn from "@material-ui/icons/GridOn";
import PermIdentity from "@material-ui/icons/PermIdentity";
import BorderOuter from "@material-ui/icons/BorderOuter";


const data = {
  menus: [
    { text: "DashBoard", icon: <Assessment />, link: "/dashboard" },
    { text: "Clients", icon: <PermIdentity />, link: "/table/totalclient" },
    {
      text: "Orders",
      icon: <GridOn />,
      // link: "/table",
      subMenus: [
        {
          text: "All Orders",
          icon: <BorderOuter />,
          link: "/table/all"
        },
        {
          text: "Active Orders",
          icon: <BorderOuter />,
          link: "/table/active"
        },
        {
          text: "Cancel Orders",
          icon: <BorderOuter />,
          link: "/table/cancel"
        },
        {
          text: "New Orders",
          icon: <BorderOuter />,
          link: "/table/new"
        }
      ]
    },
    { text: "Logout", icon: <PermIdentity />, link: "/login" }
  ],
  user: {
    userName: `${Faker.name.firstName()} ${Faker.name.lastName()}`,
    avatar: Faker.image.avatar()
  },
  tablePage: {
    items: Array.from({ length: 105 }, (item, index) => ({
      id: index,
      ProductName: Faker.commerce.productName(),
      Quantity: Faker.random.number(),
      Price: Faker.commerce.price(),
      ClientID: Faker.random.number(),
      PortID: Faker.random.number(),
      Status: Faker.random.boolean(),
    }))
  },

  ClientPage: {
    items: Array.from({ length: 105 }, (item, index) => ({
      id: index,
      name: `${Faker.name.firstName()} ${Faker.name.lastName()}`,
      email:Faker.internet.email(),
      location:Faker.address.state()
    }))
  },
  dashBoardPage: {
    recentProducts: [
      {
        id: 1,
        title: "GOOGLE",
        text: "200 Orders"
      },
      { id: 2, 
        title: "IBM", 
        text: "7  Orders" },
      {
        id: 3,
        title: "Turntabl",
        text: "70 Orders "
      },
      {
        id: 4,
        title: "MIT",
        text: "16 Orders"
      }
    ],
    monthlySales: [
      { name: "Jan", uv: 3700 },
      { name: "Feb", uv: 3000 },
      { name: "Mar", uv: 2000 },
      { name: "Apr", uv: 2780 },
      { name: "May", uv: 2000 },
      { name: "Jun", uv: 1800 },
      { name: "Jul", uv: 2600 },
      { name: "Aug", uv: 2900 },
      { name: "Sep", uv: 3500 },
      { name: "Oct", uv: 3000 },
      { name: "Nov", uv: 2400 },
      { name: "Dec", uv: 2780 }
    ],
    newOrders: [
      { pv: 250 },
      { pv: 138 },
      { pv: 980 },
      { pv: 398 },
      { pv: 480 },
      { pv: 340 },
      { pv: 430 }
    ],
    browserUsage: [
      { name: "Google", value: 800 },
      { name: "IBM", value: 300 },
      { name: "MAC", value: 300 }
    ]
  }
};

export default data;
