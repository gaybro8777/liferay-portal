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

package com.liferay.portal.search.engine.adapter.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.engine.adapter.SearchEngineAdapter;
import com.liferay.portal.search.engine.adapter.document.UpdateDocumentRequest;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author André de Oliveira
 */
@RunWith(Arquillian.class)
public class SearchEngineAdapterTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testExceptionBoundaries() {
		String index = RandomTestUtil.randomString();

		UpdateDocumentRequest updateDocumentRequest = new UpdateDocumentRequest(
			index, RandomTestUtil.randomString(), new DocumentImpl());

		updateDocumentRequest.setType(RandomTestUtil.randomString());

		try {
			_searchEngineAdapter.execute(updateDocumentRequest);

			Assert.fail("Exception was not thrown");
		}
		catch (RuntimeException runtimeException) {
			assertClientSideSafeToLoad(runtimeException);

			String message = runtimeException.getMessage();

			Assert.assertTrue(
				message,
				message.startsWith(
					"org.elasticsearch.index.IndexNotFoundException: [" +
						index + "] IndexNotFoundException[no such index"));
		}
	}

	protected void assertClientSideSafeToLoad(Throwable throwable) {
		if (throwable == null) {
			return;
		}

		Class<?> clazz = throwable.getClass();

		String name = clazz.getName();

		if (name.startsWith("org.elasticsearch")) {
			throw _getTestFrameworkSafeToLoadException(
				name, throwable.getMessage(), throwable.getStackTrace());
		}

		assertClientSideSafeToLoad(throwable.getCause());
	}

	private RuntimeException _getTestFrameworkSafeToLoadException(
		String name, String message, StackTraceElement[] stackTraceElements) {

		RuntimeException runtimeException = new RuntimeException(
			name + ": " + message);

		runtimeException.setStackTrace(stackTraceElements);

		return runtimeException;
	}

	@Inject
	private static SearchEngineAdapter _searchEngineAdapter;

}