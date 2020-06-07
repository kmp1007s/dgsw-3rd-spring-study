console.log("script load()");

const server = "http://localhost:8080";
const contentType = "application/json";
const dataType = "json";
const stringify = JSON.stringify;
let currentUserId = null;

const inputRegId = $("#input_reg_id");
const inputRegPwd = $("#input_reg_pwd");
const inputRegName = $("#input_reg_name");
const inputRegEmail = $("#input_reg_email");
const inputRegPhone = $("#input_reg_phone");

const inputPostTitle = $("#input_post_title");
const inputPostContent = $("#input_post_content");

const ajax = {
  get: function (endpoint, success) {
    $.ajax({
      url: server + endpoint,
      method: "GET",
      dataType,
      success,
    });
  },
  post: function (endpoint, data, success) {
    $.ajax({
      url: server + endpoint,
      method: "POST",
      contentType,
      data: stringify(data),
      success,
    });
  },
  put: function (endpoint, data, success) {
    $.ajax({
      url: server + endpoint,
      method: "PUT",
      contentType,
      data: stringify(data),
      success,
    });
  },
  delete: function (endpoint, success) {
    $.ajax({
      url: server + endpoint,
      method: "DELETE",
      dataType,
      success,
    });
  },
  postFormData: function (endpoint, data, success) {
    $.ajax({
      url: server + endpoint,
      method: "POST",
      processData: false,
      contentType: false,
      data,
      success,
    });
  },
};

const api = {
  register: function (data) {
    return new Promise((resolve, reject) => {
      ajax.post("/user/create", data, (res) => {
        resolve(res);
      });
    });
  },
  getUser: function (userId) {
    return new Promise((resolve, reject) => {
      ajax.get(`/user/read/${userId}`, (res) => {
        resolve(res);
      });
    });
  },
  getUserLists: function () {
    return new Promise((resolve, reject) => {
      ajax.get("/user/read", (res) => {
        resolve(res);
      });
    });
  },
  getPostLists: function () {
    return new Promise((resolve, reject) => {
      ajax.get("/post/read", (res) => {
        resolve(res);
      });
    });
  },
  createPost: function (data) {
    return new Promise((resolve, reject) => {
      ajax.post("/post/create", data, (res) => {
        resolve(res);
      });
    });
  },
  deleteUser: function (userId) {
    return new Promise((resolve, reject) => {
      ajax.delete(`/user/delete/${userId}`, (res) => {
        resolve(res);
      });
    });
  },
  deletePost: function (postId) {
    return new Promise((resolve, reject) => {
      ajax.delete(`/post/delete/${postId}`, (res) => {
        resolve(res);
      });
    });
  },
};

init();

function init() {
  console.log("init()");
  getUserLists();
  getPostLists();
}

async function requestRegister() {
  const data = {
    account: inputRegId.val().trim(),
    password: inputRegPwd.val().trim(),
    name: inputRegName.val().trim(),
    email: inputRegEmail.val().trim(),
    phone: inputRegPhone.val().trim(),
  };

  const newUser = (await api.register(data)).data;
  console.log(newUser);

  currentUserId = newUser.id;

  getUserLists();
}

function updateUserListView(users) {
  $("#list_user>tr").remove();

  for (let user of users) {
    $("#list_user").append(`
    <tr id="${user.id}">
      <td>
        <span>${user.account}</span>
      </td>
      <td>
        <span>${user.name}</span>
      </td>
      <td>
        <span>${user.email}</span>
      </td>
      <td>
        <span>${user.phone}</span>
      </td>
      <td>
        <span>${user.created}</span>
      </td>
    </tr>
    `);
  }
}

async function updatePostListView(posts) {
  $("#list_post>tr").remove();

  for (let post of posts) {
    const { account } = (await api.getUser(post.userId)).data;

    $("#list_post").append(`
    <tr id="${post.id}">
      <td>
        <span>${account}</span>
      </td>
      <td>
        <span>${post.title}</span>
      </td>
      <td>
        <span>${post.content}</span>
      </td>
      <td>
        <span>${post.created}</span>
      </td>
    </tr>
    `);
  }
}

async function getUserLists() {
  const users = (await api.getUserLists()).data;
  console.log(users);

  updateUserListView(users);
}

async function getPostLists() {
  const posts = (await api.getPostLists()).data;
  console.log(posts);

  updatePostListView(posts);
}

async function requestNewPost() {
  const data = {
    userId: currentUserId,
    title: inputPostTitle.val().trim(),
    content: inputPostContent.val().trim(),
  };

  const newPost = await api.createPost(data);
  console.log(newPost);

  getPostLists();
}
