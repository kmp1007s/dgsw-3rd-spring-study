	console.log("script load");

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
  getPost: function (postId) {
    return new Promise((resolve, reject) => {
      ajax.get(`/post/read/${postId}`, (res) => {
        resolve(res);
      });
    });
  },
  getPostByUserId: function (userId) {
    return new Promise((resolve, reject) => {
      ajax.get(`/post/read/user/${userId}`, (res) => {
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
  updateUser: function (userId, data) {
    return new Promise((resolve, reject) => {
      ajax.put(`/user/update/${userId}`, data, (res) => {
        resolve(res);
      });
    });
  },
  updatePost: function (postId, data) {
    return new Promise((resolve, reject) => {
      ajax.put(`/post/update/${postId}`, data, (res) => {
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

async function onRegisterBtnClicked() {
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

async function updateSelectedUserView(user) {
  $("#selected_user>tr").remove();

  if (!user) return;

  $("#selected_user").append(`
  <tr id="${user.id}">
  <td class="cannot_modify">
    <span>${user.account}</span>
  </td>
  <td onclick="toggleWritingMode(this)">
    <span>${user.name}</span>
    <input type="text" class="invisible"/>
  </td>
  <td onclick="toggleWritingMode(this)">
    <span>${user.email}</span>
    <input type="text" class="invisible"/>
  </td>
  <td onclick="toggleWritingMode(this)">
    <span>${user.phone}</span>
    <input type="text" class="invisible"/>
  </td>
  <td class="cannot_modify">
    <span>${user.created}</span>
  </td>
  <td>
    <button onclick="onUpdateUserBtnClicked($(this).closest('tr'))">완료</button>
  </td>
  <td>
    <button onclick="onDeleteUserBtnClicked($(this).closest('tr'))">삭제</button>
  </td>
</tr>
  `);
}

async function updatePostByUserView(post) {
  const { account } = (await api.getUser(post.userId)).data;

  $("#post_by_user>tr").remove();

  $("#post_by_user").append(`
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
    <td>
      <span>${post.modified}</span>
    </td>
  </tr>
  `);
}

async function updateSelectedPostView(post) {
  const { account } = (await api.getUser(post.userId)).data;

  $("#selected_post>tr").remove();

  if (!post) return;

  $("#selected_post").append(`
  <tr id="${post.id}">
      <td class="cannot_modify">
        <span>${account}</span>
      </td>
      <td onclick="toggleWritingMode(this)">
        <span>${post.title}</span>
        <input type="text" class="invisible"/>
      </td>
      <td onclick="toggleWritingMode(this)">
        <span>${post.content}</span>
        <input type="text" class="invisible"/>
      </td>
      <td class="cannot_modify">
        <span>${post.created}</span>
      </td>
      <td class="cannot_modify">
        <span>${post.modified}</span>
      </td>
      <td>
        <button onclick="onUpdatePostBtnClicked($(this).closest('tr'))">완료</button>
      </td>
      <td>
        <button onclick="onDeletePostBtnClicked($(this).closest('tr'))">삭제</button>
      </td>
    </tr>
  `);
}

function updateUserListView(users) {
  $("#list_user>tr").remove();

  for (let user of users) {
    $("#list_user").append(`
    <tr id="${user.id}">
      <td onclick="onViewUserBtnClicked($(this).closest('tr'))">
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
      <td>
        <button onclick="onViewPostByUserBtnClicked($(this).closest('tr'))">작성 글 보기</button>
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
      <td onclick="onViewPostBtnClicked($(this).closest('tr'))">
        <span>${post.title}</span>
      </td>
      <td>
        <span>${post.content}</span>
      </td>
      <td>
        <span>${post.created}</span>
      </td>
      <td>
        <span>${post.modified}</span>
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

async function onCreatePostBtnClicked() {
  const data = {
    userId: currentUserId,
    title: inputPostTitle.val().trim(),
    content: inputPostContent.val().trim(),
  };

  const newPost = await api.createPost(data);
  console.log(newPost);

  getPostLists();
}

async function onUpdateUserBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const values = parentTr.find("td :not(button)");
  const datas = [];

  console.log(values);

  for (let value of values) {
    value = $(value);

    if (value.parent().hasClass("cannot_modify") || value.hasClass("invisible"))
      continue;

    if (value.is("input")) datas.push(value.val().trim());
    else datas.push(value.html());
  }

  console.log(datas);

  const data = {
    name: datas[0],
    email: datas[1],
    phone: datas[2],
  };

  console.log(data);

  const updated = (await api.updateUser(id, data)).data;
  console.log(updated);

  getUserLists();
  updateSelectedUserView(updated);
}

async function onUpdatePostBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const values = parentTr.find("td :not(button)");
  const datas = [];

  console.log(values);

  for (let value of values) {
    value = $(value);

    if (value.parent().hasClass("cannot_modify") || value.hasClass("invisible"))
      continue;

    if (value.is("input")) datas.push(value.val().trim());
    else datas.push(value.html());
  }

  console.log(datas);

  const data = {
    userId: currentUserId,
    title: datas[0],
    content: datas[1],
  };

  console.log(data);

  const updated = (await api.updatePost(id, data)).data;
  console.log(updated);

  getPostLists();
  updateSelectedPostView(updated);
}

async function onDeleteUserBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const response = await api.deleteUser(id);
  console.log(response);
  getUserLists();
  updateSelectedUserView();
}

async function onDeletePostBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const response = await api.deletePost(id);
  console.log(response);
  getPostLists();
  updateSelectedPostView();
}

function toggleWritingMode(clicked) {
  clicked = $(clicked);
  console.log(clicked);

  const childrenSpan = clicked.children().eq(0);
  const childrenInput = clicked.children().eq(1);

  childrenSpan.toggleClass("invisible");
  childrenInput.toggleClass("invisible");

  if (childrenSpan.hasClass("invisible")) childrenInput.focus();
}

async function onViewPostByUserBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const post = (await api.getPostByUserId(id)).data;
  console.log(post);

  updatePostByUserView(post);
}

async function onViewUserBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const user = (await api.getUser(id)).data;
  console.log(user);

  updateSelectedUserView(user);
}

async function onViewPostBtnClicked(parentTr) {
  const id = parentTr.attr("id");
  console.log(id);

  const post = (await api.getPost(id)).data;
  console.log(post);

  updateSelectedPostView(post);
}
