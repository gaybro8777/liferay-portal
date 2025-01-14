/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.collaboration.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import com.liferay.headless.collaboration.dto.v1_0.DiscussionAttachment;
import com.liferay.headless.collaboration.resource.v1_0.DiscussionAttachmentResource;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.net.URL;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public abstract class BaseDiscussionAttachmentResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		_resourceURL = new URL(
			"http://localhost:8080/o/headless-collaboration/v1.0");
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testDeleteDiscussionAttachment() throws Exception {
		DiscussionAttachment discussionAttachment =
			testDeleteDiscussionAttachment_addDiscussionAttachment();

		assertResponseCode(
			200,
			invokeDeleteDiscussionAttachmentResponse(
				discussionAttachment.getId()));

		assertResponseCode(
			404,
			invokeGetDiscussionAttachmentResponse(
				discussionAttachment.getId()));
	}

	protected DiscussionAttachment
			testDeleteDiscussionAttachment_addDiscussionAttachment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected boolean invokeDeleteDiscussionAttachment(
			Long discussionAttachmentId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath(
					"/discussion-attachments/{discussion-attachment-id}",
					discussionAttachmentId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		try {
			return _outputObjectMapper.readValue(string, Boolean.class);
		}
		catch (Exception e) {
			Assert.fail("HTTP response: " + string);

			throw e;
		}
	}

	protected Http.Response invokeDeleteDiscussionAttachmentResponse(
			Long discussionAttachmentId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		options.setDelete(true);

		String location =
			_resourceURL +
				_toPath(
					"/discussion-attachments/{discussion-attachment-id}",
					discussionAttachmentId);

		options.setLocation(location);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	@Test
	public void testGetDiscussionAttachment() throws Exception {
		DiscussionAttachment postDiscussionAttachment =
			testGetDiscussionAttachment_addDiscussionAttachment();

		DiscussionAttachment getDiscussionAttachment =
			invokeGetDiscussionAttachment(postDiscussionAttachment.getId());

		assertEquals(postDiscussionAttachment, getDiscussionAttachment);
		assertValid(getDiscussionAttachment);
	}

	protected DiscussionAttachment
			testGetDiscussionAttachment_addDiscussionAttachment()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected DiscussionAttachment invokeGetDiscussionAttachment(
			Long discussionAttachmentId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-attachments/{discussion-attachment-id}",
					discussionAttachmentId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		try {
			return _outputObjectMapper.readValue(
				string, DiscussionAttachment.class);
		}
		catch (Exception e) {
			Assert.fail("HTTP response: " + string);

			throw e;
		}
	}

	protected Http.Response invokeGetDiscussionAttachmentResponse(
			Long discussionAttachmentId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-attachments/{discussion-attachment-id}",
					discussionAttachmentId);

		options.setLocation(location);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	@Test
	public void testGetDiscussionForumPostingDiscussionAttachmentsPage()
		throws Exception {

		Long discussionForumPostingId =
			testGetDiscussionForumPostingDiscussionAttachmentsPage_getDiscussionForumPostingId();
		Long irrelevantDiscussionForumPostingId =
			testGetDiscussionForumPostingDiscussionAttachmentsPage_getIrrelevantDiscussionForumPostingId();

		if ((irrelevantDiscussionForumPostingId != null)) {
			DiscussionAttachment irrelevantDiscussionAttachment =
				testGetDiscussionForumPostingDiscussionAttachmentsPage_addDiscussionAttachment(
					irrelevantDiscussionForumPostingId,
					randomIrrelevantDiscussionAttachment());

			Page<DiscussionAttachment> page =
				invokeGetDiscussionForumPostingDiscussionAttachmentsPage(
					irrelevantDiscussionForumPostingId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantDiscussionAttachment),
				(List<DiscussionAttachment>)page.getItems());
			assertValid(page);
		}

		DiscussionAttachment discussionAttachment1 =
			testGetDiscussionForumPostingDiscussionAttachmentsPage_addDiscussionAttachment(
				discussionForumPostingId, randomDiscussionAttachment());

		DiscussionAttachment discussionAttachment2 =
			testGetDiscussionForumPostingDiscussionAttachmentsPage_addDiscussionAttachment(
				discussionForumPostingId, randomDiscussionAttachment());

		Page<DiscussionAttachment> page =
			invokeGetDiscussionForumPostingDiscussionAttachmentsPage(
				discussionForumPostingId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(discussionAttachment1, discussionAttachment2),
			(List<DiscussionAttachment>)page.getItems());
		assertValid(page);
	}

	protected DiscussionAttachment
			testGetDiscussionForumPostingDiscussionAttachmentsPage_addDiscussionAttachment(
				Long discussionForumPostingId,
				DiscussionAttachment discussionAttachment)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetDiscussionForumPostingDiscussionAttachmentsPage_getDiscussionForumPostingId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetDiscussionForumPostingDiscussionAttachmentsPage_getIrrelevantDiscussionForumPostingId()
		throws Exception {

		return null;
	}

	protected Page<DiscussionAttachment>
			invokeGetDiscussionForumPostingDiscussionAttachmentsPage(
				Long discussionForumPostingId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-forum-postings/{discussion-forum-posting-id}/discussion-attachments",
					discussionForumPostingId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		return _outputObjectMapper.readValue(
			string,
			new TypeReference<Page<DiscussionAttachment>>() {
			});
	}

	protected Http.Response
			invokeGetDiscussionForumPostingDiscussionAttachmentsPageResponse(
				Long discussionForumPostingId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-forum-postings/{discussion-forum-posting-id}/discussion-attachments",
					discussionForumPostingId);

		options.setLocation(location);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	@Test
	public void testPostDiscussionForumPostingDiscussionAttachment()
		throws Exception {

		Assert.assertTrue(true);
	}

	protected DiscussionAttachment
			testPostDiscussionForumPostingDiscussionAttachment_addDiscussionAttachment(
				DiscussionAttachment discussionAttachment)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected DiscussionAttachment
			invokePostDiscussionForumPostingDiscussionAttachment(
				Long discussionForumPostingId, MultipartBody multipartBody)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-forum-postings/{discussion-forum-posting-id}/discussion-attachments",
					discussionForumPostingId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		try {
			return _outputObjectMapper.readValue(
				string, DiscussionAttachment.class);
		}
		catch (Exception e) {
			Assert.fail("HTTP response: " + string);

			throw e;
		}
	}

	protected Http.Response
			invokePostDiscussionForumPostingDiscussionAttachmentResponse(
				Long discussionForumPostingId, MultipartBody multipartBody)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-forum-postings/{discussion-forum-posting-id}/discussion-attachments",
					discussionForumPostingId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	@Test
	public void testGetDiscussionThreadDiscussionAttachmentsPage()
		throws Exception {

		Long discussionThreadId =
			testGetDiscussionThreadDiscussionAttachmentsPage_getDiscussionThreadId();
		Long irrelevantDiscussionThreadId =
			testGetDiscussionThreadDiscussionAttachmentsPage_getIrrelevantDiscussionThreadId();

		if ((irrelevantDiscussionThreadId != null)) {
			DiscussionAttachment irrelevantDiscussionAttachment =
				testGetDiscussionThreadDiscussionAttachmentsPage_addDiscussionAttachment(
					irrelevantDiscussionThreadId,
					randomIrrelevantDiscussionAttachment());

			Page<DiscussionAttachment> page =
				invokeGetDiscussionThreadDiscussionAttachmentsPage(
					irrelevantDiscussionThreadId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantDiscussionAttachment),
				(List<DiscussionAttachment>)page.getItems());
			assertValid(page);
		}

		DiscussionAttachment discussionAttachment1 =
			testGetDiscussionThreadDiscussionAttachmentsPage_addDiscussionAttachment(
				discussionThreadId, randomDiscussionAttachment());

		DiscussionAttachment discussionAttachment2 =
			testGetDiscussionThreadDiscussionAttachmentsPage_addDiscussionAttachment(
				discussionThreadId, randomDiscussionAttachment());

		Page<DiscussionAttachment> page =
			invokeGetDiscussionThreadDiscussionAttachmentsPage(
				discussionThreadId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(discussionAttachment1, discussionAttachment2),
			(List<DiscussionAttachment>)page.getItems());
		assertValid(page);
	}

	protected DiscussionAttachment
			testGetDiscussionThreadDiscussionAttachmentsPage_addDiscussionAttachment(
				Long discussionThreadId,
				DiscussionAttachment discussionAttachment)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetDiscussionThreadDiscussionAttachmentsPage_getDiscussionThreadId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetDiscussionThreadDiscussionAttachmentsPage_getIrrelevantDiscussionThreadId()
		throws Exception {

		return null;
	}

	protected Page<DiscussionAttachment>
			invokeGetDiscussionThreadDiscussionAttachmentsPage(
				Long discussionThreadId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-threads/{discussion-thread-id}/discussion-attachments",
					discussionThreadId);

		options.setLocation(location);

		String string = HttpUtil.URLtoString(options);

		return _outputObjectMapper.readValue(
			string,
			new TypeReference<Page<DiscussionAttachment>>() {
			});
	}

	protected Http.Response
			invokeGetDiscussionThreadDiscussionAttachmentsPageResponse(
				Long discussionThreadId)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-threads/{discussion-thread-id}/discussion-attachments",
					discussionThreadId);

		options.setLocation(location);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	@Test
	public void testPostDiscussionThreadDiscussionAttachment()
		throws Exception {

		Assert.assertTrue(true);
	}

	protected DiscussionAttachment
			testPostDiscussionThreadDiscussionAttachment_addDiscussionAttachment(
				DiscussionAttachment discussionAttachment)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected DiscussionAttachment
			invokePostDiscussionThreadDiscussionAttachment(
				Long discussionThreadId, MultipartBody multipartBody)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-threads/{discussion-thread-id}/discussion-attachments",
					discussionThreadId);

		options.setLocation(location);

		options.setPost(true);

		String string = HttpUtil.URLtoString(options);

		try {
			return _outputObjectMapper.readValue(
				string, DiscussionAttachment.class);
		}
		catch (Exception e) {
			Assert.fail("HTTP response: " + string);

			throw e;
		}
	}

	protected Http.Response
			invokePostDiscussionThreadDiscussionAttachmentResponse(
				Long discussionThreadId, MultipartBody multipartBody)
		throws Exception {

		Http.Options options = _createHttpOptions();

		String location =
			_resourceURL +
				_toPath(
					"/discussion-threads/{discussion-thread-id}/discussion-attachments",
					discussionThreadId);

		options.setLocation(location);

		options.setPost(true);

		HttpUtil.URLtoString(options);

		return options.getResponse();
	}

	protected void assertResponseCode(
		int expectedResponseCode, Http.Response actualResponse) {

		Assert.assertEquals(
			expectedResponseCode, actualResponse.getResponseCode());
	}

	protected void assertEquals(
		DiscussionAttachment discussionAttachment1,
		DiscussionAttachment discussionAttachment2) {

		Assert.assertTrue(
			discussionAttachment1 + " does not equal " + discussionAttachment2,
			equals(discussionAttachment1, discussionAttachment2));
	}

	protected void assertEquals(
		List<DiscussionAttachment> discussionAttachments1,
		List<DiscussionAttachment> discussionAttachments2) {

		Assert.assertEquals(
			discussionAttachments1.size(), discussionAttachments2.size());

		for (int i = 0; i < discussionAttachments1.size(); i++) {
			DiscussionAttachment discussionAttachment1 =
				discussionAttachments1.get(i);
			DiscussionAttachment discussionAttachment2 =
				discussionAttachments2.get(i);

			assertEquals(discussionAttachment1, discussionAttachment2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<DiscussionAttachment> discussionAttachments1,
		List<DiscussionAttachment> discussionAttachments2) {

		Assert.assertEquals(
			discussionAttachments1.size(), discussionAttachments2.size());

		for (DiscussionAttachment discussionAttachment1 :
				discussionAttachments1) {

			boolean contains = false;

			for (DiscussionAttachment discussionAttachment2 :
					discussionAttachments2) {

				if (equals(discussionAttachment1, discussionAttachment2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				discussionAttachments2 + " does not contain " +
					discussionAttachment1,
				contains);
		}
	}

	protected void assertValid(DiscussionAttachment discussionAttachment) {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertValid(Page<DiscussionAttachment> page) {
		boolean valid = false;

		Collection<DiscussionAttachment> discussionAttachments =
			page.getItems();

		int size = discussionAttachments.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected boolean equals(
		DiscussionAttachment discussionAttachment1,
		DiscussionAttachment discussionAttachment2) {

		if (discussionAttachment1 == discussionAttachment2) {
			return true;
		}

		return false;
	}

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_discussionAttachmentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_discussionAttachmentResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		DiscussionAttachment discussionAttachment) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("contentUrl")) {
			sb.append("'");
			sb.append(String.valueOf(discussionAttachment.getContentUrl()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("encodingFormat")) {
			sb.append("'");
			sb.append(String.valueOf(discussionAttachment.getEncodingFormat()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fileExtension")) {
			sb.append("'");
			sb.append(String.valueOf(discussionAttachment.getFileExtension()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("sizeInBytes")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(discussionAttachment.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected DiscussionAttachment randomDiscussionAttachment() {
		return new DiscussionAttachment() {
			{
				contentUrl = RandomTestUtil.randomString();
				encodingFormat = RandomTestUtil.randomString();
				fileExtension = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				title = RandomTestUtil.randomString();
			}
		};
	}

	protected DiscussionAttachment randomIrrelevantDiscussionAttachment() {
		return randomDiscussionAttachment();
	}

	protected DiscussionAttachment randomPatchDiscussionAttachment() {
		return randomDiscussionAttachment();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;

	protected static class Page<T> {

		public Collection<T> getItems() {
			return new ArrayList<>(items);
		}

		public long getLastPage() {
			return lastPage;
		}

		public long getPage() {
			return page;
		}

		public long getPageSize() {
			return pageSize;
		}

		public long getTotalCount() {
			return totalCount;
		}

		@JsonProperty
		protected Collection<T> items;

		@JsonProperty
		protected long lastPage;

		@JsonProperty
		protected long page;

		@JsonProperty
		protected long pageSize;

		@JsonProperty
		protected long totalCount;

	}

	private Http.Options _createHttpOptions() {
		Http.Options options = new Http.Options();

		options.addHeader("Accept", "application/json");

		String userNameAndPassword = "test@liferay.com:test";

		String encodedUserNameAndPassword = Base64.encode(
			userNameAndPassword.getBytes());

		options.addHeader(
			"Authorization", "Basic " + encodedUserNameAndPassword);

		options.addHeader("Content-Type", "application/json");

		return options;
	}

	private String _toPath(String template, Object... values) {
		if (ArrayUtil.isEmpty(values)) {
			return template;
		}

		for (int i = 0; i < values.length; i++) {
			template = template.replaceFirst(
				"\\{.*\\}", String.valueOf(values[i]));
		}

		return template;
	}

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;
	private final static ObjectMapper _inputObjectMapper = new ObjectMapper() {
		{
			setFilterProvider(
				new SimpleFilterProvider() {
					{
						addFilter(
							"Liferay.Vulcan",
							SimpleBeanPropertyFilter.serializeAll());
					}
				});
			setSerializationInclusion(JsonInclude.Include.NON_NULL);
		}
	};
	private final static ObjectMapper _outputObjectMapper = new ObjectMapper() {
		{
			setFilterProvider(
				new SimpleFilterProvider() {
					{
						addFilter(
							"Liferay.Vulcan",
							SimpleBeanPropertyFilter.serializeAll());
					}
				});
		}
	};

	@Inject
	private DiscussionAttachmentResource _discussionAttachmentResource;

	private URL _resourceURL;

}