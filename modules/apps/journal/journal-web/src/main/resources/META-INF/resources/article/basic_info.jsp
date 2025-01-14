<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticle article = journalDisplayContext.getArticle();

JournalEditArticleDisplayContext journalEditArticleDisplayContext = new JournalEditArticleDisplayContext(request, liferayPortletResponse, article);

DDMStructure ddmStructure = journalEditArticleDisplayContext.getDDMStructure();
%>

<aui:input name="groupId" type="hidden" value="<%= journalEditArticleDisplayContext.getGroupId() %>" />
<aui:input name="ddmStructureKey" type="hidden" value="<%= ddmStructure.getStructureKey() %>" />

<p class="article-structure">
	<b><liferay-ui:message key="structure" /></b>: <%= HtmlUtil.escape(ddmStructure.getName(locale)) %>
</p>

<c:if test="<%= article != null %>">
	<p class="article-version-status">
		<b><liferay-ui:message key="version" />: <%= article.getVersion() %></b>

		<span class="label label-<%= LabelItem.getStyleFromWorkflowStatus(article.getStatus()) %> text-uppercase">
			<liferay-ui:message key="<%= WorkflowConstants.getStatusLabel(article.getStatus()) %>" />
		</span>
	</p>
</c:if>

<c:choose>
	<c:when test="<%= !journalWebConfiguration.journalArticleForceAutogenerateId() %>">
		<div class="article-id">
			<label for="<portlet:namespace />newArticleId"><liferay-ui:message key="id" /></label>

			<aui:input disabled="<%= true %>" label="" name="newArticleId" type="text" value="<%= (article != null) ? article.getArticleId() : StringPool.BLANK %>" wrapperCssClass="mb-1" />

			<%
			String taglibOnChange = "Liferay.Util.toggleDisabled('#" + renderResponse.getNamespace() + "newArticleId', event.target.checked);";
			%>

			<aui:input checked="<%= true %>" label="autogenerate-id" name="autoArticleId" onChange="<%= taglibOnChange %>" type="checkbox" value="<%= true %>" wrapperCssClass="mb-3" />
		</div>

		<aui:script>
			Liferay.Util.disableToggleBoxes('<portlet:namespace />autoArticleId', '<portlet:namespace />newArticleId', true);
		</aui:script>
	</c:when>
	<c:otherwise>
		<aui:input name="newArticleId" type="hidden" />
		<aui:input name="autoArticleId" type="hidden" value="<%= true %>" />
	</c:otherwise>
</c:choose>

<div class="article-content-description">
	<label for="<portlet:namespace />descriptionMapAsXML"><liferay-ui:message key="summary" /></label>

	<liferay-ui:input-localized
		cssClass="form-control"
		defaultLanguageId="<%= journalEditArticleDisplayContext.getDefaultLanguageId() %>"
		editorName="alloyeditor"
		formName="fm"
		ignoreRequestValue="<%= journalEditArticleDisplayContext.isChangeStructure() %>"
		name="descriptionMapAsXML"
		placeholder="description"
		type="editor"
		xml="<%= (article != null) ? article.getDescriptionMapAsXML() : StringPool.BLANK %>"
	/>
</div>