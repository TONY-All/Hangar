package io.papermc.hangar.controller.extras.pagination.filters.projects;

import io.papermc.hangar.controller.extras.pagination.Filter;
import io.papermc.hangar.controller.extras.pagination.filters.projects.ProjectQueryFilter.ProjectQueryFilterInstance;
import org.jdbi.v3.core.statement.SqlStatement;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class ProjectQueryFilter implements Filter<ProjectQueryFilterInstance> {

    @Override
    public String getQueryParamName() {
        return "q";
    }

    @Override
    public String getDescription() {
        return "The query to use when searching";
    }

    @NotNull
    @Override
    public ProjectQueryFilterInstance create(NativeWebRequest webRequest) {
        return new ProjectQueryFilterInstance(webRequest.getParameter(getQueryParamName()));
    }

    static class ProjectQueryFilterInstance implements FilterInstance {

        private final String query;

        ProjectQueryFilterInstance(String query) {
            this.query = query;
        }

        @Override
        public void createSql(StringBuilder sb, SqlStatement<?> q) {
            sb.append(" AND (hp.search_words @@ websearch_to_tsquery");
            if (!query.endsWith(" ")) {
                 sb.append("_postfix");
            }
            sb.append("('english', :query)").append(")");
            q.bind("query", query.trim());
        }

        @Override
        public String toString() {
            return "ProjectQueryFilterInstance{" +
                    "query='" + query + '\'' +
                    '}';
        }
    }
}
